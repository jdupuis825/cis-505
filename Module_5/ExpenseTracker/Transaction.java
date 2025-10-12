/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: 
        Comprehensive Version (12th ed.). Pearson Education, Inc.
    Dupuis, J. (2025). CSI 505 Intermediate Java Programming. Bellevue University. Modified by A. Student 2025.
*/

package Module_5.ExpenseTracker;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The Transaction class represents a single expense transaction.
 * It includes the date, description, and amount of the transaction,
 * with support for default values and formatted output.
 */
public class Transaction {
    // Private data fields
    private String date;         // Date of the transaction in "MM-dd-yyyy" format.
    private String description;  // Description of the transaction.
    private double amount;       // Amount spent in the transaction.

    // Accessor (getter) methods.
    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    // Mutator (setter) methods.
    public void setDate(String date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * No-argument constructor
     * Initializes a default transaction with today's date,
     * empty description, and zero amount.
     */
    public Transaction() {
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
        this.date = formatter.format(new Date()); // Sets today's date.
        this.description = "";                    // Default to empty string.
        this.amount = 0.0;                        // Default to zero.
    }

    /**
     * Argument constructor
     * Initializes a transaction with specified date, description, and amount.
     */
    public Transaction(String date, String description, double amount) {
        this.date = date;
        this.description = description;
        this.amount = amount;
    }

    /**
     * toString override
     * Returns a formatted string with all transaction details,
     * each on a separate line.
     */
    @Override
    public String toString() {
        return date + "\n" + description + "\n" + amount;
    }
}
