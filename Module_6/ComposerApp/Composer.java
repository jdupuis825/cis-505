/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: 
        Comprehensive Version (12th ed.). Pearson Education, Inc.
    Dupuis, J. (2025). CSI 505 Intermediate Java Programming. Bellevue University. Modified by A. Student 2025.
*/

package Module_6.ComposerApp;

// Represents a music composer with an ID, name, and genre.
public class Composer {
    // Unique identifier for the composer.
    private int id;

    // Composer's name
    private String name;

    // Composer's musical genre.
    private String genre;

    // Default constructor initializes fields to default values.
    public Composer() {
        this.id = 0;
        this.name = "";
        this.genre = "";
    }

    // Constructor with parameters to initialize all fields.
    public Composer(int id, String name, String genre) {
        this.id = id;
        this.name = name;
        this.genre = genre;
    }

    // Accessor for id.
    public int getId() {
        return id;
    }

    // Accessor for name.
    public String getName() {
        return name;
    }

    // Accessor for genre.
    public String getGenre() {
        return genre;
    }

    // Returns a formatted string with composer details.
    @Override
    public String toString() {
        return "Id: " + id + "\nName: " + name + "\nGenre: " + genre;
    }
}

