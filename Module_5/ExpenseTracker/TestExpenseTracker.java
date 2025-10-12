/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: 
        Comprehensive Version (12th ed.). Pearson Education, Inc.
    Dupuis, J. (2025). CSI 505 Intermediate Java Programming. Bellevue University. Modified by A. Student 2025.
*/

package Module_5.ExpenseTracker;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The TestExpenseTracker class provides a console interface
 * for viewing, adding, and totaling expense transactions.
 */
public class TestExpenseTracker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String choice = "y";

        // Main program loop.
        while (choice.equalsIgnoreCase("y")) {
            // Display menu.
            System.out.println("\n Welcome to the Expense Tracker");
            System.out.println("\n MENU OPTIONS");
            System.out.println("   1. View Transactions");
            System.out.println("   2. Add Transactions");
            System.out.println("   3. View Expense");

            // Validate menu selection.
            int input = ValidatorIO.getInt(sc, "\n Please choose an option: ");

            // Option 1: Allows users to view transactions.
            if (input == 1) {
                try {
                    ArrayList<Transaction> transactions = TransactionIO.findAll();

                    for (Transaction t : transactions) {
                        System.out.println("\n Date: " + t.getDate());
                        System.out.println(" Description: " + t.getDescription());
                        System.out.println(" Amount: " + String.format("$%,6.2f", t.getAmount()));
                    }
                } catch (IOException e) {
                    System.out.println("\n Exception: " + e.getMessage());
                }

                // Prompts user to continue or not.
                choice = ValidatorIO.getString(sc, "\n Continue? (y/n): ");
            }

            // Option 2: Allows user to add transactions.
            else if (input == 2) {
                String c = "y";
                ArrayList<Transaction> transactions = new ArrayList<>();

                // Loop to add multiple transactions.
                while (c.equalsIgnoreCase("y")) {
                    String description = ValidatorIO.getString(sc, "\n Enter the description: ");
                    double amount = ValidatorIO.getDouble(sc, " Enter the amount: ");

                    // Use today's date as default.
                    Transaction transaction = new Transaction();
                    transaction.setDescription(description);
                    transaction.setAmount(amount);

                    transactions.add(transaction);

                    c = ValidatorIO.getString(sc, "\n Add another transaction? (y/n): ");
                }

                // Writes transactions to file.
                try {
                    TransactionIO.bulkInsert(transactions);
                } catch (IOException e) {
                    System.out.println("\n Exception: " + e.getMessage());
                }

                // Prompt user to continue or not.
                choice = ValidatorIO.getString(sc, "\n Continue? (y/n): ");
            }

            // Option 3: Allows user to view expense total.
            else if (input == 3) {
                try {
                    ArrayList<Transaction> transactions = TransactionIO.findAll();
                    double monthlyExpense = 0.0;

                    for (Transaction transaction : transactions) {
                        monthlyExpense += transaction.getAmount();
                    }

                    System.out.println("\n Your total monthly expense is " +
                            String.format("$%,6.2f", monthlyExpense));
                } catch (IOException e) {
                    System.out.println("\n Exception: " + e.getMessage());
                }

                // Prompts user to continue or not.
                choice = ValidatorIO.getString(sc, "\n Continue? (y/n): ");
            }

            // Invalid input display.
            else {
                System.out.println("\n Invalid option.");
                choice = ValidatorIO.getString(sc, "\n Continue? (y/n): ");
            }
        }

        sc.close();
    }
}
