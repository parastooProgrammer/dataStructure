package setFamily;

import java.util.Comparator;
import java.util.TreeSet;

public class CustomOrderTreeSet<T> {

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
