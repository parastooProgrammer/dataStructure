package setFamily;

import java.util.Comparator;
import java.util.TreeSet;

public class CustomOrderTreeSet<T> {
    /*
           10
      /  \
     5    20
         /   \
       15     25
Binary Search Tree (BST) Structure – Every left child is smaller, and every right child is larger.

Self-Balancing (Red-Black Tree) – Ensures O(log n) operations.

No Duplicates – A TreeSet does not allow duplicate elements.
     */
    TreeSet<T> treeSet;


    public TreeSet<T> getTreeSet() {
        return treeSet;
    }

    public void setTreeSet(Comparator<T> customComparator) {
        this.treeSet = new TreeSet<>(customComparator);
    }

    public CustomOrderTreeSet(Comparator<T> customComparator) {
        setTreeSet(customComparator);
    }
}
