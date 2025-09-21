    import java.util.ArrayList;
    import java.util.List;

    class PlayerGameStats {
        public Game game;
        public Player player;
        public int fieldGoals;
        public int threePoints;
        public int freeThrows;
        public int offensiveRebounds;
        public int defensiveRebounds;
        public int assists;
        private int rebounds;

        public PlayerGameStats(Game game,
                               Player player,
                               int fieldGoals,
                               int threePoints,
                               int freeThrows,
                               int offensiveRebounds,
                               int defensiveRebounds,
                               int assists,
                               int rebounds) {
            this.game = game;
            this.player = player;
            this.fieldGoals = fieldGoals;
            this.threePoints = threePoints;
            this.freeThrows = freeThrows;
            this.offensiveRebounds = offensiveRebounds;
            this.defensiveRebounds = defensiveRebounds;
            this.assists = assists;
            this.rebounds = rebounds;
        }

        // Getters and setters
        public Player getPlayer() {
            return player;
        }

        public int getOffensiveRebounds() {
            return offensiveRebounds;
        }

        public int getDefensiveRebounds() {
            return defensiveRebounds;
        }

        public int getAssists() {
            return assists;
        }

        public int getFieldGoals() {
            return fieldGoals;
        }

        public int getThreePoints() {
            return threePoints;
        }

        public int getFreeThrows() {
            return freeThrows;
        }

        public int getPoints() {
            int onlyTwoPointFieldGoals = fieldGoals - threePoints;
            return (onlyTwoPointFieldGoals * 2) + (threePoints * 3) + freeThrows;
        }

        public int getRebounds() {
            return rebounds;
        }

        // Add method to get individual score by a player in a game here
        public int getPlayerGameScore() {
            return (fieldGoals * 2) + (threePoints * 3) + freeThrows;
        }

        // Add method to populate player game stats here
        public static void populatePlayerGameStats(List<Game> games, int[][][] playerStatsOfAllGames) {
            for (int gameIndex = 0; gameIndex < games.size(); gameIndex++) {
                Game game = games.get(gameIndex);
                int[][] playerStats = playerStatsOfAllGames[gameIndex];
                List<PlayerGameStats> stats = new ArrayList<>();

                List<Player> homePlayers = game.getHomeTeam().getPlayers();
                List<Player> awayPlayers = game.getAwayTeam().getPlayers();

                for (int i = 0; i < 5; i++) {
                    int fieldGoals = playerStats[i][0];
                    int threePoints = playerStats[i][1];
                    int freeThrows = playerStats[i][2];
                    int offensiveRebounds = playerStats[i][3];
                    int defensiveRebounds = playerStats[i][4];
                    int assists = playerStats[i][5];
                    int rebounds = offensiveRebounds + defensiveRebounds;

                    PlayerGameStats stat = new PlayerGameStats(
                        game,
                        awayPlayers.get(i),
                        fieldGoals,
                        threePoints,
                        freeThrows,
                        offensiveRebounds,
                        defensiveRebounds,
                        assists,
                        rebounds
                    );
                    stats.add(stat);
                }

                for (int i = 0; i < 5; i++) {
                    int fieldGoals = playerStats[i + 5][0];
                    int threePoints = playerStats[i + 5][1];
                    int freeThrows = playerStats[i + 5][2];
                    int offensiveRebounds = playerStats[i + 5][3];
                    int defensiveRebounds = playerStats[i + 5][4];
                    int assists = playerStats[i + 5][5];
                    int rebounds = offensiveRebounds + defensiveRebounds;

                    PlayerGameStats stat = new PlayerGameStats(
                        game,
                        homePlayers.get(i),
                        fieldGoals,
                        threePoints,
                        freeThrows,
                        offensiveRebounds,
                        defensiveRebounds,
                        assists,
                        rebounds
                    );
                    stats.add(stat);
                }

                game.setPlayerStats(stats);
            }

        }
    }