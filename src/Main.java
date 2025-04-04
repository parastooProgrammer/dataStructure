import general.Person;
import setFamily.CustomOrderTreeSet;

import java.util.Comparator;

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
    }
}