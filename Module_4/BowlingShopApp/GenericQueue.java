/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: 
        Comprehensive Version (12th ed.). Pearson Education, Inc.
    Dupuis, J. (2025). CSI 505 Intermediate Java Programming. Bellevue University. Modified by A. Student 2025.
*/

package Module_4.BowlingShopApp;

import java.util.LinkedList;

// Generic queue implementation using LinkedList.
public class GenericQueue<T> {
    private LinkedList<T> list = new LinkedList<>();

    // Adds item to the front of the queue.
    public void enqueue(T item) {
        list.addFirst(item);
    }

    // Removes and returns the first item in the queue.
    public T dequeue() {
        return list.removeFirst();
    }

    // Returns the number of items in the queue.
    public int size() {
        return list.size();
    }
}

