import java.util.List;
import java.util.ArrayList;

class Game {
    // Data members
    public int gameNumber;
    public String date;
    public Team homeTeam;
    public Team awayTeam;
    public int attendance;
    private List<PlayerGameStats> playerStats;

    // Constructor
    public Game(int gameNumber, String date, Team homeTeam, Team awayTeam, int attendance) {
        this.gameNumber = gameNumber;
        this.date = date;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.attendance = attendance;
        this.playerStats = new ArrayList<>();
    }


    // Getters and setters
    public Team getHomeTeam() {
        return homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setPlayerStats(List<PlayerGameStats> stats) {
        this.playerStats = stats;
    }

    public List<PlayerGameStats> getPlayerStats() {
        return playerStats;
    }


    public int getTeamScore(Team team) {
        return getScoreForTeam(team);
    }
    public int getGameNumber() {
        return gameNumber;
    }

    // Other Member functions
    public Player getTopScorerForTeam(Team team) {
        Player topScorer = null;
        int maxPoints = -1;

        for (PlayerGameStats stats : playerStats) {
            Player player = stats.getPlayer();
            if (player.getTeam().equals(team)) {
                if (stats.getPoints() > maxPoints) {
                    maxPoints = stats.getPoints();
                    topScorer = player;
                }
            }
        }

        return topScorer;
    }

    // Method to populate games
    public static List<Game> populateGame(List<Team> teams, String[][] gameData) {
        List<Game> games = new ArrayList<>();
        for (String[] data : gameData) {
            int gameNumber = Integer.parseInt(data[0]); // Game number
            String date = data[1]; // Game date
            Team homeTeam = teams.get(Integer.parseInt(data[2])); // Get home team
            Team awayTeam = teams.get(Integer.parseInt(data[3])); // Get away team
            int attendance = Integer.parseInt(data[4]); // Attendance
            // Create and add game to list
            Game game = new Game(gameNumber, date, homeTeam, awayTeam, attendance);
            games.add(game);
        }
        return games;
    }

    // Method to print game details
    public void printGameDetails() {
        System.out.println("Game #" + gameNumber);
        System.out.println("Date: " + date);
        System.out.println("Attendance: " + attendance);

        System.out.print("Home Team:");
        homeTeam.printTeamData();


        System.out.print("Away Team:");
        awayTeam.printTeamData();
    }

    // method to print resume game
    public void gameSummary() {
        int homeScore = 0;
        int awayScore = 0;

        for (PlayerGameStats stat : playerStats) {
            if (homeTeam.getPlayers().contains(stat.getPlayer())) {
                homeScore += stat.getPlayerGameScore();
            } else {
                awayScore += stat.getPlayerGameScore();
            }
        }

        System.out.println("Game # " + gameNumber + ":");
        System.out.println("Team " + homeTeam.name + " score: " + homeScore);
        System.out.println("Team " + awayTeam.name + " score: " + awayScore);

        if (homeScore > awayScore) {
            System.out.println(homeTeam.name + " wins against " + awayTeam.name + " with a score of " + homeScore + " - " + awayScore);
        } else {
            System.out.println(awayTeam.name + " wins against " + homeTeam.name + " with a score of " + awayScore + " - " + homeScore);
        }

        System.out.println("-------------------------------------------------------");
    }

    // method to print highest player of teams
    public void highestScorer() {
        Player homeScorer = null;
        int homeMax = -1;

        Player awayScorer = null;
        int awayMax = -1;

        for (PlayerGameStats stat : playerStats) {
            int score = stat.getPlayerGameScore();
            if (homeTeam.getPlayers().contains(stat.getPlayer())) {
                if (score > homeMax) {
                    homeMax = score;
                    homeScorer = stat.getPlayer();
                }
            } else {
                if (score > awayMax) {
                    awayMax = score;
                    awayScorer = stat.getPlayer();
                }
            }
        }

        System.out.println("Team: " + awayTeam.name + ", Highest Scorer: " + awayScorer.getName());
        System.out.println("Team: " + homeTeam.name + ", Highest Scorer: " + homeScorer.getName());
        System.out.println("-------------------------------------------------------");
    }

    public int getScoreForTeam(Team team) {
        int total = 0;
        for (PlayerGameStats stats : playerStats) {
            if (stats.getPlayer().getTeam().equals(team)) {
                total += stats.getPoints();
            }
        }
        return total;
    }

    public Team getWinner() {
        int homeScore = getScoreForTeam(homeTeam);
        int awayScore = getScoreForTeam(awayTeam);

        if (homeScore > awayScore) return homeTeam;
        else if (awayScore > homeScore) return awayTeam;
        else return null; // empate
    }

    public void addStats(PlayerGameStats stats) {
        this.playerStats.add(stats);
    }

}