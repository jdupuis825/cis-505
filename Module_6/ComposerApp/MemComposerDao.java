/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: 
        Comprehensive Version (12th ed.). Pearson Education, Inc.
    Dupuis, J. (2025). CSI 505 Intermediate Java Programming. Bellevue University. Modified by A. Student 2025.
*/

package Module_6.ComposerApp;

import java.util.ArrayList;
import java.util.List;

// In-memory implementation of ComposerDao.
public class MemComposerDao implements ComposerDao {
    // Internal list to store composer objects.
    private List<Composer> composers;

    // Initializes the list with five default composers.
    public MemComposerDao() {
        composers = new ArrayList<>();
        composers.add(new Composer(1007, "Ludwig Van Beethoven", "Classical"));
        composers.add(new Composer(1008, "Johann Sebastian Bach", "Classical"));
        composers.add(new Composer(1009, "Wolfgang Amadeus Mozart", "Classical"));
        composers.add(new Composer(1010, "Johannes Brahms", "Classical"));
        composers.add(new Composer(1011, "Joseph Haydn", "Classical"));
    }

    // Returns full list of composers.
    @Override
    public List<Composer> findAll() {
        return composers;
    }

    // Finds a composer by ID.
    @Override
    public Composer findBy(Integer id) {
        for (Composer composer : composers) {
            if (composer.getId() == id) {
                return composer;
            }
        }
        return null; // Not null.
    }

    // Adds a new composer to the list.
    @Override
    public void insert(Composer composer) {
        composers.add(composer);
    }
}

