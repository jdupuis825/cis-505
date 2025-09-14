/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: 
        Comprehensive Version (12th ed.). Pearson Education, Inc.
    Dupuis, J. (2025). CSI 505 Intermediate Java Programming. Bellevue University. Modified by A. Student 2025.
*/

public class TestFanApp {
    public static void main(String[] args) {
        // Fan using default constructor for Fan A.
        Fan FanA = new Fan();

        // Fan B - speed = MEDIUM (speed = 2), on = true, radius = 8.0, color = Blue.
        Fan FanB = new Fan(Fan.MEDIUM, true, 8.0, "Blue");

        // Display both fans using system.out.println.
        System.out.println(FanA.toString());
        System.out.println(FanB.toString());
    }
}

