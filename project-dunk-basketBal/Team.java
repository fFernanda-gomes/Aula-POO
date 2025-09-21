import java.util.ArrayList;
import java.util.List;

public class Team {
    public String name;
    public String conference;
    private List<Player> players;

    public Team(String name, String conference) {
        this.name = name;
        this.conference = conference;
        this.players = new ArrayList<>();
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public String getConference() {
        return conference;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }


    // Other Member functions

    // Add method to populate teams here
    public static List<Team> populateTeams(String[][] teamData, String[][] playerData) {
        List<Team> teams = new ArrayList<>();

        for (String[] data : teamData) {
            String name = data[0];
            String conference = data[1];
            Team team = new Team(name, conference);
            teams.add(team);
        }

        for (String[] playerInfo : playerData) {
            int teamIndex = Integer.parseInt(playerInfo[0]);
            String playerName = playerInfo[1];
            int playerNumber = Integer.parseInt(playerInfo[2]);

            Team team = teams.get(teamIndex);
            Player player = new Player(playerName, playerNumber, team);
            team.addPlayer(player);
        }

        return teams;
    }


    // Method to print individial team 
    public void printTeam() {
        System.out.println("Team Name: " + getName() + ", Conference: " + getConference());
    }

    // Method to print team data
    public void printTeamData() {
        System.out.println("-------------------------------------------------------");
        printTeam();
        System.out.println("-------------------------------------------------------");
        for (Player player : getPlayers()) {
            player.printPlayer();
        }
    }
}