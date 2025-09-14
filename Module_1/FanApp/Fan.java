/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: 
        Comprehensive Version (12th ed.). Pearson Education, Inc.
    Dupuis, J. (2025). CSI 505 Intermediate Java Programming. Bellevue University. Modified by A. Student 2025.
*/ 
public class Fan {
    // Constants for the fan speed and speed values.
    public static final int STOPPED = 0;
    public static final int SLOW = 1;
    public static final int MEDIUM = 2;
    public static final int FAST = 3;
    
    // Private fields for the fan.
    private int speed; // Private int data field for the fan speed (default is stopped).
    private boolean on; // Private boolean to specify if the fan is on or off (default is off).
    private double radius; // Private double data field -radius- to specify fan radius (default is 6).
    private String color; // Private string data field -color- to specify the fan color (default is white).

     // No-argument constructor.
    public Fan() {
        this.speed = STOPPED;
        this.on = false;
        this.radius = 6.0;
        this.color = "white";
    }

    // Argument constructor.
    public Fan(int speed, boolean on, double radius, String color) {
        this.speed = speed;
        this.on = on;
        this.radius = radius;
        this.color = color;
    }
    
    // Accessor (getter) method for speed.
    public int getSpeed (){
        return this.speed;
    }
    // Mutator (setter) method for speed.
    public void setSpeed (int s){
        this.speed = s;
    }
    // Accessor (getter) method for fan on and off.
    public boolean getOn(){
        return this.on;
    }
    // Mutator (setter) method for fan on and off.
    public void setIsOn (boolean o){
        this.on = o;
    }
    // Accessor (getter) method for fan radius.
    public double getRadius (){
        return this.radius;
    }
    // Mutator (setter) method for fan radius.
    public void setRadius (double r){
        this.radius = r;
    }
    // Accessor (getter) methods for fan color.
    public String getColoString (){
        return this.color;
    }
    // Mutator (setter) method for fan color.
    public void setColorString (String c){
        this.color = c;
    }

    // toString method override.
    public String toString (){
        String s = new String();
            // If the fan is on, the method returns the fan speed, radius, and color in string.
            if (this.on == true) {
                s = ("The fan speed is set to " + speed + " with a color of " + color + " and a radius of " + radius + ".");
            // If the fan is off, the method returns the fan color, radius, "and the fan is off" message in a string. 
            } else { s = ("The fan is " + color + " with a radius of " + radius + " and the fan is off.");
        } 
            // Returns description for the fan.
            return s;
    }
}