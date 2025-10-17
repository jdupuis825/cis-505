/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: 
        Comprehensive Version (12th ed.). Pearson Education, Inc.
    Dupuis, J. (2025). CSI 505 Intermediate Java Programming. Bellevue University. Modified by A. Student 2025.
*/

package Module_6.ComposerApp;

import java.util.List;

// Generic interface for basic data access operations.
public interface GenericDao<E, K> {
    // Returns all entities of type E.
    List<E> findAll();

    // Find a single entity by key.
    E findBy(K key);

    // Inserts a new entity into the data source.
    void insert(E entity);
}

