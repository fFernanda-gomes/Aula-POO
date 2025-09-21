import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tournament {
    public String name;
    public String season;
    public List<Team> teams;
    public static List<Game> games;
    public Player mvp;

    public Tournament(String name, String season) {
        this.name = name;
        this.season = season;
        this.teams = new ArrayList<>();
        this.games = new ArrayList<>();
    }

    // Getters and setters
    public void addTeam(Team team) {
        teams.add(team);
    }

    public List<Team> getTeams() {
        return teams;
    }

    public String getName() {
        return name;
    }

    public void addGame(Game game) {
        games.add(game);
    }

    public static List<Game> getGames() {
        return games;
    }

    public Player getMvp() {
        return mvp;
    }

    public void setMvp(Player player) {
        this.mvp = player;
    }

    public void loadStats(int[][][] playerStatsOfAllGames) {
        PlayerGameStats.populatePlayerGameStats(games, playerStatsOfAllGames);
    }

    public Player highestScorer() {
        Map<Player, Integer> playerPoints = new HashMap<>();

        for (Game game : games) {
            for (PlayerGameStats stats : game.getPlayerStats()) {
                Player player = stats.getPlayer();
                int points = stats.getPoints();
                playerPoints.put(player, playerPoints.getOrDefault(player, 0) + points);
            }
        }

        Player highestScorer = null;
        int maxPoints = 0;

        for (Map.Entry<Player, Integer> entry : playerPoints.entrySet()) {
            if (entry.getValue() > maxPoints) {
                maxPoints = entry.getValue();
                highestScorer = entry.getKey();
            }
        }

        return highestScorer;
    }

    public PlayerGameStats mvpStats() {
        if (mvp == null) return null;

        int totalFieldGoals = 0;
        int totalThreePoints = 0;
        int totalFreeThrows = 0;
        int totalOffReb = 0;
        int totalDefReb = 0;
        int totalAssists = 0;

        for (Game game : games) {
            for (PlayerGameStats stats : game.getPlayerStats()) {
                if (stats.getPlayer().equals(mvp)) {
                    totalFieldGoals += stats.getFieldGoals();
                    totalThreePoints += stats.getThreePoints();
                    totalFreeThrows += stats.getFreeThrows();
                    totalOffReb += stats.getOffensiveRebounds();
                    totalDefReb += stats.getDefensiveRebounds();
                    totalAssists += stats.getAssists();
                }
            }
        }

        return new PlayerGameStats(
                games.isEmpty() ? null : games.get(0),
                mvp,
                totalFieldGoals,
                totalThreePoints,
                totalFreeThrows,
                totalOffReb,
                totalDefReb,
                totalAssists,
                totalOffReb + totalDefReb
        );
    }

    public Team getTournamentWinner() {
        Map<Team, Integer> wins = new HashMap<>();

        for (Game game : games) {
            Team winner = game.getWinner();
            if (winner != null) {
                wins.put(winner, wins.getOrDefault(winner, 0) + 1);
            }
        }

        Team champion = null;
        int maxWins = 0;
        for (Map.Entry<Team, Integer> entry : wins.entrySet()) {
            if (entry.getValue() > maxWins) {
                maxWins = entry.getValue();
                champion = entry.getKey();
            }
        }

        return champion;
    }

    public void printTournamentSummary() {
        System.out.println("Tournament: " + name);
        System.out.println("-------------------------------------------------------");

        for (Game game : games) {
            System.out.println("\n---Game-wise Stats---");
            System.out.println("Game # " + game.getGameNumber() + ":");

            int homeScore = game.getTeamScore(game.getHomeTeam());
            int awayScore = game.getTeamScore(game.getAwayTeam());

            System.out.println("Team " + game.getAwayTeam().getName() + " score: " + awayScore);
            System.out.println("Team " + game.getHomeTeam().getName() + " score: " + homeScore);

            if (homeScore > awayScore) {
                System.out.println(game.getHomeTeam().getName() + " wins against " + game.getAwayTeam().getName()
                        + " with a score of " + homeScore + " - " + awayScore);
            } else if (awayScore > homeScore) {
                System.out.println(game.getAwayTeam().getName() + " wins against " + game.getHomeTeam().getName()
                        + " with a score of " + awayScore + " - " + homeScore);
            } else {
                System.out.println("The game ended in a tie: " + homeScore + " - " + awayScore);
            }

            System.out.println("-------------------------------------------------------");

            for (Team team : new Team[]{game.getHomeTeam(), game.getAwayTeam()}) {
                Player topPlayer = game.getTopScorerForTeam(team);
                if (topPlayer != null) {
                    System.out.println("Team: " + team.getName() + ", Highest Scorer: " + topPlayer.getName());
                }
            }

            System.out.println("-------------------------------------------------------");
        }

        Team winner = getTournamentWinner();
        System.out.println("\nTournament Winner: " + (winner != null ? winner.getName() : "Empate"));

        Player highestScorer = highestScorer();
        if (highestScorer != null) {
            System.out.println("Highest Scorer of the Tournament: " + highestScorer.getName());
        }

        System.out.println("-------------------------------------------------------");

        this.mvp = highestScorer();
        PlayerGameStats mvp = mvpStats();
        if (mvp != null) {
            Player mvpPlayer = mvp.getPlayer();
            int gamesPlayed = 0;
            for (Game game : games) {
                for (PlayerGameStats stats : game.getPlayerStats()) {
                    if (stats.getPlayer().equals(mvpPlayer)) {
                        gamesPlayed++;
                    }
                }
            }

            System.out.println("MVP Stats:");
            System.out.println("-- MVP Player: " + mvpPlayer.getName());
            System.out.println("-- Total Rebounds: " + mvp.getRebounds());
            System.out.println("-- Total Assists: " + mvp.getAssists());
            System.out.println("-- Total Games Played: " + gamesPlayed);
            System.out.println("-- Total Points Scored: " + mvp.getPoints());
        } else {
            System.out.println("MVP: Não definido");
        }

        System.out.println("-------------------------------------------------------");
    }
}
