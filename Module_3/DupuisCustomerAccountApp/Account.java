/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: 
        Comprehensive Version (12th ed.). Pearson Education, Inc.
    Dupuis, J. (2025). CSI 505 Intermediate Java Programming. Bellevue University. Modified by A. Student 2025.
*/

package Module_3.DupuisCustomerAccountApp;

import java.text.SimpleDateFormat;
import java.util.Date;

// Represents a bank account with deposit, withdrawal, and balance features.
public class Account {
    // private data filed: balance (default is set to $200).
    private double balance = 200.0;

    // Accessor method returns the current account balance.
    public double getBalance() {
        return balance;
    }

    // Public void method adds the specified amount to the account balance.
    public void deposit(double amt) {
        balance += amt;
    }

    // Public void method withdraws/deducts the specified amount if sufficient funds are available.
    public void withdraw(double amt) {
        if (balance >= amt) {
            balance -= amt;
        //else statement to for insufficient funds.
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    // Public method to displays the account menu options (matches Figure 3.5/assignment instructions).
    public void displayMenu() {
        System.out.println("\nAccount Menu");
        System.out.println("Enter <D/d> for deposit");
        System.out.println("Enter <W/w> for withdraw");
        System.out.println("Enter <B/b> for balance");
        System.out.print("  Enter option>: ");
    }

    // Public method returns the current date formatted as MM-dd-yyyy.
    public String getTransactionDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        return sdf.format(new Date());
    }
}

