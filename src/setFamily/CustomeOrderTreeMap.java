package setFamily;

import java.util.Comparator;
import java.util.TreeMap;


public class CustomeOrderTreeMap<T> {
    TreeMap treeMap;


    public TreeMap getTreeMap() {
        return treeMap;
    }

    public void setTreeMap(Comparator<T> customComparator) {
        this.treeMap = new TreeMap(customComparator);
    }

    public CustomeOrderTreeMap(Comparator<T> customComparator) {
        setTreeMap(customComparator);
    }
}
