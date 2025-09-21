import java.util.List;
import java.util.ArrayList;

public class Player {
    private String name;
    private int number;
    private Team team;

    // Construtor
    public Player(String name, int number, Team team) {
        this.name = name;
        this.number = number;
        this.team = team;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public Team getTeam() {
        return team;
    }

    // Method to populate players
    public static List<Player> populatePlayer(String[][] playerData, Team team) {
        List<Player> players = new ArrayList<>();
        for (String[] data : playerData) {
            String name = data[0];
            int number = Integer.parseInt(data[1]);
            Player player = new Player(name, number, team);
            players.add(player);
        }
        return players;
    }

    // Method to print a single player
    public void printPlayer() {
        System.out.println("Player Name: " + this.getName() + ", Player Number: " + this.getNumber());
    }
}
