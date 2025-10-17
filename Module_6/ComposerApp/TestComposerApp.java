/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: 
        Comprehensive Version (12th ed.). Pearson Education, Inc.
    Dupuis, J. (2025). CSI 505 Intermediate Java Programming. Bellevue University. Modified by A. Student 2025.
*/

package Module_6.ComposerApp;

import java.util.Scanner;

// Application to interact with composer data.
public class TestComposerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MemComposerDao dao = new MemComposerDao();
        int choice;

        // Display welcome message once at the start of the program.
        System.out.println("\nWelcome to the Composer App");

        // Main menu loop.
        do {
            // Display menu options.
            System.out.println("\nMENU OPTIONS");
            System.out.println("  1. View Composers");
            System.out.println("  2. Find Composer");
            System.out.println("  3. Add Composer");
            System.out.println("  4. Exit\n");
            System.out.print("Please choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline.

            switch (choice) {
                case 1:
                    // Displays all composers.
                    System.out.println("\n--DISPLAYING COMPOSERS--");
                    for (Composer c : dao.findAll()) {
                        System.out.println(c);
                        System.out.println(); // Extra spacing between composers.
                    }
                    break;
                case 2:
                    // Promt for ID and display matching composer.
                    System.out.print("\nEnter an id: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline.
                    Composer found = dao.findBy(id);
                    if (found != null) {
                        System.out.println("\n--DISPLAYING COMPOSER--");
                        System.out.println(found);
                    } else {
                        System.out.println("\nComposer not found.");
                    }
                    break;
                case 3:
                    // Prompt for new composer details and adds to list.
                    System.out.print("\nEnter an id: ");
                    int newId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline.
                    System.out.print("Enter a name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter a genre: ");
                    String genre = scanner.nextLine();
                    dao.insert(new Composer(newId, name, genre));
                    System.out.println("\nComposer added.");
                    break;
                case 4:
                    // Exit the program.
                    System.out.println("\nExiting program.");
                    break;
                default:
                    // Handle for invalid input.
                    System.out.println("\nInvalid choice. Try again.");
            }
        } while (choice != 4);

        scanner.close(); // Clean up resources.
    }
}

