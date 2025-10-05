/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: 
        Comprehensive Version (12th ed.). Pearson Education, Inc.
    Dupuis, J. (2025). CSI 505 Intermediate Java Programming. Bellevue University. Modified by A. Student 2025.
*/

package Module_4.BowlingShopApp;

// Subclass represents a bowling ball.
public class Ball extends Product {
    // Color of the ball ("Black and Red").
    private String color = "";

    // No-argument constructor initializes default color.
    public Ball() {}

    // Accessor and mutator for ball color.
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    // Appends color to the superclass's product details.
    @Override
    public String toString() {
        return super.toString() + "\nColor: " + color;
    }
}

