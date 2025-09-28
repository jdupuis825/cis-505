/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: 
        Comprehensive Version (12th ed.). Pearson Education, Inc.
    Dupuis, J. (2025). CSI 505 Intermediate Java Programming. Bellevue University. Modified by A. Student 2025.
*/

package Module_3.DupuisCustomerAccountApp;

import java.util.Scanner;

// Main application class to test Customer, Account, and CustomerDB classes.
public class TestCustomerAccountApp {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account account = new Account(); // Creates an account with default balance.

        // Prompt user for customer ID and retrieve corresponding Customer object.
        System.out.print("Enter customer number (1007–1009): ");
        int id = sc.nextInt();
        sc.nextLine(); // Consumes leftover newline.
        Customer customer = CustomerDB.getCustomer(id); // Store the result.

        String choice;
        // Loop to allow user to select multiple transactions until user chooses to exit.
        do {
            account.displayMenu(); // Shows menu options.
            String option = sc.nextLine().trim().toLowerCase(); // Normalizes input.

            // Handles user selection.
            switch (option) {
                case "d":
                    System.out.print("\nEnter deposit amount: ");
                    double depositAmt = sc.nextDouble();
                    sc.nextLine(); // Consume newline
                    account.deposit(depositAmt);
                    break;
                case "w":
                    System.out.print("\nEnter withdraw amount: ");
                    double withdrawAmt = sc.nextDouble();
                    sc.nextLine(); // Consume newline
                    account.withdraw(withdrawAmt);
                    break;
                case "b":
                    // Display current balance using formatted output.
                    System.out.printf("Account balance: $%,6.2f\n", account.getBalance());
                    break;
                default:
                    // Handle invalid menu selection.
                    System.out.println("Error: Invalid option");
            }

            // Ask user if they want to continue.
            System.out.print("Continue? (y/n): ");
            choice = sc.nextLine().trim().toLowerCase();

        } while (choice.equals("y")); // Repeat loop if user enters 'y'.

        // Final output: show customer details and timestamped balance.
        System.out.println("\n--Customer Details--");
        System.out.println(customer.toString());
        System.out.printf("\nBalance as of %s is $%,6.2f\n", account.getTransactionDate(), account.getBalance());
        System.out.println("\nEnd of line...");

        // Close the Scanner to prevent resource leak.
        sc.close();
    }
}

