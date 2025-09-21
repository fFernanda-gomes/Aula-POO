import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Tournament tournament = new Tournament("Philadelphia 76ers at Los Angeles Lakers", "2001");

        Team lakers = new Team("Los Angeles Lakers", "Western Conference");
        lakers.addPlayer(new Player("Shaquille O'Neal", 34, lakers));
        lakers.addPlayer(new Player("Kobe Bryant", 8, lakers));
        lakers.addPlayer(new Player("Rick Fox", 17, lakers));
        lakers.addPlayer(new Player("Derek Fisher", 2, lakers));
        lakers.addPlayer(new Player("Horace Grant", 54, lakers));

        Team sixers = new Team("Philadelphia 76ers", "Eastern Conference");
        sixers.addPlayer(new Player("Allen Iverson", 3, sixers));
        sixers.addPlayer(new Player("Dikembe Mutombo", 55, sixers));
        sixers.addPlayer(new Player("Aaron McKie", 9, sixers));
        sixers.addPlayer(new Player("Eric Snow", 20, sixers));
        sixers.addPlayer(new Player("Tyrone Hill", 40, sixers));

        tournament.addTeam(lakers);
        tournament.addTeam(sixers);

        String[] gameDates = {"2001-06-06", "2001-06-08", "2001-06-10", "2001-06-13"};
        int[][][] playerStatsOfAllGames = new int[][][] {
                {
                        {18, 3, 9, 2, 3, 6}, {3, 1, 2, 2, 5, 9}, {4, 0, 5, 5, 11, 0}, {1, 0, 2, 1, 5, 0}, {2, 0, 0, 0, 0, 0},
                        {7, 0, 1, 0, 3, 5}, {17, 0, 10, 6, 14, 5}, {7, 3, 2, 1, 6, 5}, {3, 0, 2, 4, 1, 0}, {0, 0, 0, 0, 0, 1}
                },
                {
                        {10, 3, 0, 0, 4, 3}, {6, 2, 0, 4, 2, 6}, {5, 0, 6, 4, 9, 1}, {1, 0, 0, 1, 4, 0}, {1, 1, 0, 0, 3, 0},
                        {11, 1, 8, 1, 7, 6}, {12, 0, 4, 8, 12, 9}, {5, 2, 2, 0, 0, 3}, {0, 0, 0, 1, 5, 2}, {2, 0, 2, 2, 3, 2}
                },
                {
                        {12, 3, 10, 2, 10, 4}, {9, 0, 5, 5, 7, 0}, {2, 0, 1, 1, 5, 8}, {1, 0, 0, 0, 2, 0}, {1, 1, 0, 0, 1, 0},
                        {13, 0, 6, 0, 6, 3}, {11, 0, 8, 3, 9, 3}, {2, 0, 3, 1, 1, 2}, {2, 0, 0, 3, 4, 1}, {1, 0, 1, 0, 0, 2}
                },
                {
                        {12, 1, 10, 1, 3, 4}, {9, 0, 1, 3, 6, 0}, {1, 0, 3, 0, 3, 2}, {3, 0, 1, 2, 5, 1}, {0, 0, 0, 1, 2, 1},
                        {6, 0, 7, 2, 8, 9}, {1, 0, 8, 8, 6, 5}, {4, 2, 0, 0, 1, 1}, {2, 1, 2, 0, 1, 4}, {1, 0, 0, 0, 5, 0}
                }
        };

        for (int i = 0; i < 4; i++) {
            int gameNumber = i + 1;
            String date = gameDates[i];
            Team home = sixers;
            Team away = lakers;
            int attendance = 15000;

            Game game = new Game(gameNumber, date, home, away, attendance);
            for (int j = 0; j < 10; j++) {
                Player player = (j < 5) ? sixers.getPlayers().get(j) : lakers.getPlayers().get(j - 5);
                int[] stats = playerStatsOfAllGames[i][j];
                int rebounds = stats[3] + stats[4];
                PlayerGameStats stat = new PlayerGameStats(game, player, stats[0], stats[1], stats[2], stats[3], stats[4], stats[5], rebounds);
                game.addStats(stat);
            }
            tournament.addGame(game);
        }


        tournament.printTournamentSummary();
    }
}
