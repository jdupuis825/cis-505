/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: 
        Comprehensive Version (12th ed.). Pearson Education, Inc.
    Dupuis, J. (2025). CSI 505 Intermediate Java Programming. Bellevue University. Modified by A. Student 2025.
*/

package SportsTeamApp;
import java.util.Scanner;

// Main application to build and display sports teams.
public class TestSportsTeamApp {
    public static void main(String[] args) {
        // Creates Scanner object for user input.
        Scanner scanner = new Scanner(System.in);

        // Flag to control whether to continue entering teams.
        boolean continueInput = true;

        // Loop allowing multiple teams to be entered.
        while (continueInput) {
            // Prompt to enter team name.
            System.out.print("Bills ");
            String teamName = scanner.nextLine().trim();

            // Creates a new Team object.
            Team team = new Team(teamName);

            // Prompt to enter player names.
            System.out.print("Allen,Coleman,Knox");
            String playerInput = scanner.nextLine();

            // Ensures that input is not empty.
            while (playerInput.trim().isEmpty()) {
                System.out.print("Player names cannot be empty. Please enter again: ");
                playerInput = scanner.nextLine();
            }

            // Splits input into individual names.
            String[] playerNames = playerInput.split(",");

            // Adds each player entered to the team.
            for (String player : playerNames) {
                team.addPlayer(player.trim()); // Trims whitespace
            }

            // Display the team summary.
            System.out.println(""); 
            System.out.println("  --Team Summary--"); 
            System.out.println("  Number of players in team " + team.getPlayerCount()); 
            System.out.print("  Players on team: "); 
        
        // Uses the inputted values to create a new instance of the Team class, while using the player names to invoke the addPlayer method.
        String[] teamPlayers = team.getPlayers();
        for (int i = 0; i < team.getPlayerCount(); i++) {
            System.out.print(teamPlayers[i] + " ");
        }
        System.out.println();
        
        System.out.println(""); 
        System.out.print("  Do you want to continue? (y/n) ");  // If y (yes) then it will shoot the logic back to the top of the while loop.
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("n")) {
            continueInput = false;
            System.out.println(""); 
            System.out.println("  End of line..."); 
        }
    }
        // Close the scanner to free resources.
        scanner.close();
    }
}
