/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: 
        Comprehensive Version (12th ed.). Pearson Education, Inc.
    Dupuis, J. (2025). CSI 505 Intermediate Java Programming. Bellevue University. Modified by A. Student 2025.
*/

package Module_4.BowlingShopApp;

// Subclass represents a bowling bag.
public class Bag extends Product {
    // Type of bag ("Single", "Double", "Triple").
    private String type = "";

    // No-argument constructor initializes default type.
    public Bag() {}

    // Accessor and mutator for bag type.
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    // Appends type to the superclass's product details.
    @Override
    public String toString() {
        return super.toString() + "\nType: " + type;
    }
}

