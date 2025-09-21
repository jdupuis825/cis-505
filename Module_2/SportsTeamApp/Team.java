/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: 
        Comprehensive Version (12th ed.). Pearson Education, Inc.
    Dupuis, J. (2025). CSI 505 Intermediate Java Programming. Bellevue University. Modified by A. Student 2025.
*/

package SportsTeamApp;

public class Team {
    // Stores the name of the team.
    private String teamName;

    // Array to hold player names (default size is 20).
    private String[] players;

    // Tracks/counts how many players have been added.
    private int playerCount;

    /**
     * Constructor initializes the team with a name and empty player list.
     * @param teamName // The name of the team.
     */
    public Team(String teamName) {
        this.teamName = teamName;
        this.players = new String[20]; // Fixed-size array for default player size.
        this.playerCount = 0;
    }

    /**
     * Adds a player to the team if there's room.
     * @param playerName the name of the player added.
     */
    public void addPlayer(String playerName) {
        if (playerCount < players.length) {
            players[playerCount] = playerName;
            playerCount++;
        } else {
            System.out.println("Team is full. Cannot add more players.");
        }
    }

    /**
     * Returns the array of player names.
     * @return array of players
     */
    public String[] getPlayers() {
        return players;
    }

    /**
     * Returns the number of players currently on the team.
     * @return player count
     */
    public int getPlayerCount() {
        return playerCount;
    }

    /**
     * Returns the name of the team.
     * @return team name
     */
    public String getTeamName() {
        return teamName;
    }
}
