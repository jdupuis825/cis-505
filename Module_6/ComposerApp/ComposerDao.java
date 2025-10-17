/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: 
        Comprehensive Version (12th ed.). Pearson Education, Inc.
    Dupuis, J. (2025). CSI 505 Intermediate Java Programming. Bellevue University. Modified by A. Student 2025.
*/

package Module_6.ComposerApp;

// Specialized DAO interface for Composer entities.
public interface ComposerDao extends GenericDao<Composer, Integer> {
    // Inserts findAll, findBy, and insert methods from GenericDao.
}

