/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: 
        Comprehensive Version (12th ed.). Pearson Education, Inc.
    Dupuis, J. (2025). CSI 505 Intermediate Java Programming. Bellevue University. Modified by A. Student 2025.
*/

package Module_4.BowlingShopApp;

import java.util.Scanner;

// Main application to test the bowling shop product system.
public class TestBowlingShopApp {

    // Displays the menu options to the user.
    public static void displayMenu() {
        System.out.println("\nMENU OPTIONS");
        System.out.println("  1. <b> Bowling Balls");
        System.out.println("  2. <a> Bowling Bags");
        System.out.println("  3. <s> Bowling Shoes");
        System.out.println("  4. <x> To exit");
        System.out.print("\nPlease choose an option: ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String choice;

        // Loop until user chooses to exit.
        do {
            displayMenu();
            choice = scanner.nextLine();

            // Retrieves products based on user input.
            if (!choice.equalsIgnoreCase("x")) {
                GenericQueue<Product> products = ProductDB.getProducts(choice);

                // Print header once before listing products
                if (products.size() > 0) {
                    System.out.println("\n--Product Listing--");
                }

                // Loops through and displays each product in the queue.
                while (products.size() > 0) {
                    Product p = products.dequeue();
                    System.out.println(p.toString());
                    System.out.println(); // Adds a blank line between products.
                }
            }

        } while (!choice.equalsIgnoreCase("x"));
        
        System.out.println();
        System.out.println("End of line...");
        scanner.close();
    }
}

