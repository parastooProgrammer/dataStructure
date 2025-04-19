import challenges.CodeChallenge;
import general.Person;
import setFamily.CustomOrderTreeSet;
import setFamily.CustomeOrderTreeMap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
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
        treeMap.put("Charlie",6);
        treeMap.put("Bob",2);

        System.out.println(treeMap);

      /*
          code Challenge
         */

        System.out.println(CodeChallenge.longestSubarrayWith2DistinctItemDiffOne(List.of(0,1,1,2,2,3)));

         /*
          code Challenge
         */

        CodeChallenge.canBeMadeSmallerBySwapping(Arrays.asList("java", "spring", "boot"));

        Integer[] array = {1, 2, 2, 3, 4, 4, 5};

        // Remove duplicates using streams and distinct()
        Integer[] distinctArray = Arrays.stream(array)
                .distinct()
                .toArray(Integer[]::new);
    }
}