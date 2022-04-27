import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Object o = new Object();

        Person p1 = new Person("Ivan", "Ivanov", 25);
        Person p2 = new Person("Petar", "Petrov", 15);

        System.out.println(p1);
        System.out.println(p2);

        System.out.println(p1 == p2);
        System.out.println(p1.equals(p2));

//        Map<Person, Person> people = new HashMap<>();
//        people.put(p1, p1);
//
//        Set<Person> people2 = new HashSet<>();
//        people2.add(p1);

//        Map<Person, Person> people = new TreeMap<>();
//        people.put(p1, p1);
//
//        Set<Person> people2 = new TreeSet<>();
//        people2.add(p1);

//        List<Person> people = new LinkedList<>();
//        people.add(p1);
//        people.add(p2);
        Person[] people = {p1, p2};
        Arrays.sort(people);

        for (Person p : people) {
            System.out.println(p);
        }
    }
}




