/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: 
        Comprehensive Version (12th ed.). Pearson Education, Inc.
    Dupuis, J. (2025). CSI 505 Intermediate Java Programming. Bellevue University. Modified by A. Student 2025.
*/

package Module_3.DupuisCustomerAccountApp;

// Simulates a customer database with static lookup by ID.
public class CustomerDB {
    // Public static method returns a Customer object based on the provided ID.
    public static Customer getCustomer(int id) {
        // Match known customer IDs and return corresponding Customer object.
        if (id == 1007) {
            return new Customer("William Trowbridge", "123 Main St", "Springfield", "62704");
        } else if (id == 1008) {
            return new Customer("Kim Smith", "456 Kae Ave", "Greenville", "29601");
        } else if (id == 1009) {
            return new Customer("Devrin Lee", "789 Front Rd", "Fairview", "37062");
        } else {
            // Return default customer if ID is not recognized.
            return new Customer();
        }
    }
}
