import general.Person;
import setFamily.CustomOrderTreeSet;
import setFamily.CustomeOrderTreeMap;

import java.util.Comparator;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {

        /*
          set family -> customOrderTreeSet
         */

        Comparator<Person> ageComparator = Comparator.comparingInt(Person::getAge);
        CustomOrderTreeSet<Person> customOrderTreeSet = new CustomOrderTreeSet<>(ageComparator);

        customOrderTreeSet.getTreeSet().add(new Person("Alice", 30));
        customOrderTreeSet.getTreeSet().add(new Person("Bob", 25));
        customOrderTreeSet.getTreeSet().add(new Person("Charlie", 35));

        System.out.println(customOrderTreeSet.getTreeSet());

            /*
          set family -> customOrderTreeMap
         */


        CustomeOrderTreeMap<Person> customeTreeMap = new CustomeOrderTreeMap<>(ageComparator);

        customeTreeMap.getTreeMap().put(new Person("Alice", 30),3);
        customeTreeMap.getTreeMap().put(new Person("Bob", 25),6);
        customeTreeMap.getTreeMap().put(new Person("Charlie", 35),2);

        System.out.println(customeTreeMap.getTreeMap());

        TreeMap treeMap=new TreeMap();
        treeMap.put("Alice",3);
        treeMap.put("Bob",6);
        treeMap.put("Charlie",2);

        System.out.println(treeMap);

    }
}