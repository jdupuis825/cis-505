/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: 
        Comprehensive Version (12th ed.). Pearson Education, Inc.
    Dupuis, J. (2025). CSI 505 Intermediate Java Programming. Bellevue University. Modified by A. Student 2025.
*/

package Module_5.ExpenseTracker;

import java.util.Scanner;

/**
 * The ValidatorIO class provides static methods to validate user input.
 * It ensures that only valid integers, doubles, and strings are accepted
 * from the console using a Scanner object.
 */
public class ValidatorIO {

    /**
     * Prompts the user until a valid integer is entered.
     * @param sc Scanner object for reading input.
     * @param prompt Message to display to the user.
     * @return Validated integer input.
     */
    public static int getInt(Scanner sc, String prompt) {
        int input = 0;
        boolean isValid = false;

        while (!isValid) {
            System.out.print(prompt);

            if (sc.hasNextInt()) {
                input = sc.nextInt();
                isValid = true;
            } else {
                System.out.println("Error! Invalid integer value.");
                sc.nextLine(); // Clear invalid input.
            }
        }
        return input;
    }

    /**
     * Prompts the user until a valid double is entered.
     * @param sc Scanner object for reading input.
     * @param prompt Message to display to the user.
     * @return Validated double input.
     */
    public static double getDouble(Scanner sc, String prompt) {
        double input = 0.0;
        boolean isValid = false;

        while (!isValid) {
            System.out.print(prompt);

            if (sc.hasNextDouble()) {
                input = sc.nextDouble();
                isValid = true;
            } else {
                System.out.println("Error! Invalid double value.");
                sc.nextLine(); // Clear invalid input.
            }
        }
        return input;
    }

    /**
     * Prompts the user and returns the next string input.
     * @param sc Scanner object for reading input.
     * @param prompt Message to display to the user.
     * @return User-entered string.
     */
    public static String getString(Scanner sc, String prompt) {
        System.out.print(prompt);
        return sc.next();
    }
}
