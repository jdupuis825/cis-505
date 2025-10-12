/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: 
        Comprehensive Version (12th ed.). Pearson Education, Inc.
    Dupuis, J. (2025). CSI 505 Intermediate Java Programming. Bellevue University. Modified by A. Student 2025.
*/

package Module_5.ExpenseTracker;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The TransactionIO class handles reading and writing Transaction objects
 * to and from a text file named "expenses.txt".
 */
public class TransactionIO {

    // Constant file name used for storing transactions.
    private static final String FILE_NAME = "expenses.txt";

    // File object representing the expenses file.
    private static File file = new File(FILE_NAME);

    /**
     * Writes a list of transactions to the expenses.txt file.
     * Appends to the file if it exists; creates a new file otherwise.
     *
     * @param transactions ArrayList of Transaction objects to write.
     * @throws IOException if file writing fails.
     */
    public static void bulkInsert(ArrayList<Transaction> transactions) throws IOException {
        PrintWriter output;

        if (file.exists()) {
            output = new PrintWriter(new FileOutputStream(new File(FILE_NAME), true));
        } else {
            output = new PrintWriter(FILE_NAME);
        }

        for (Transaction tran : transactions) {
            output.print(tran.getDate() + " ");
            output.print(tran.getDescription() + " ");
            output.println(tran.getAmount());
        }

        output.close();
    }

    /**
     * Reads all transactions from the expenses.txt file and returns them
     * as an ArrayList of Transaction objects.
     *
     * @return ArrayList of Transaction objects read from the file.
     * @throws IOException if file reading fails.
     */
    public static ArrayList<Transaction> findAll() throws IOException {
        ArrayList<Transaction> transactions = new ArrayList<>();
        Scanner input = new Scanner(file);

        while (input.hasNext()) {
            String date = input.next();
            String description = input.next();
            double amount = input.nextDouble();

            Transaction t = new Transaction(date, description, amount);
            transactions.add(t);
        }

        input.close();
        return transactions;
    }
}

