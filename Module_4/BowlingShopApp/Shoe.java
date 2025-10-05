/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: 
        Comprehensive Version (12th ed.). Pearson Education, Inc.
    Dupuis, J. (2025). CSI 505 Intermediate Java Programming. Bellevue University. Modified by A. Student 2025.
*/

package Module_4.BowlingShopApp;

// Subclass represents bowling shoes.
public class Shoe extends Product {
    // Shoe size (e.g., 8.5)
    private double size = 0.0;

    // No-argument constructor initializes default size.
    public Shoe() {}

    // Accessor and mutator for shoe size.
    public double getSize() { return size; }
    public void setSize(double size) { this.size = size; }

    // Appends size to the superclass's product details.
    @Override
    public String toString() {
        return super.toString() + "\nSize: " + size;
    }
}

