import java.util.*;

public class Main {
    public static void main(String[] args) {
        Object o = new Object();

        Person p3 = new Person("Ivan", "Ivanov", 25);
        Person p1 = new Person("Petar", "Petrov", 15);
        Person p2 = new Person("Petar", "Petrov", 15);

        System.out.println(p1);
        System.out.println(p2);

        System.out.println(p1 == p2);
        System.out.println(p1.equals(p2));
        System.out.println(p1.toString().equals(p2.toString()));
        System.out.println(Objects.equals(p1.toString(), p2.toString()));

        Set<Person> persons = new HashSet<>();
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
        System.out.println(persons.size());

        Map<Person, Person> persons2 = new HashMap<>();
        Set<Person> persons3 = new TreeSet<>();

        Person[] persons4 = {p1, p2, p3};
        Arrays.sort(persons4);

        for (Person p : persons4) {
            System.out.println(p);
        }
    }
}
