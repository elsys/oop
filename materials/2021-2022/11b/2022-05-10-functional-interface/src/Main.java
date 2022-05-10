import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    static private class MyClass implements ICallable {
        @Override
        public int call(int arg) {
            System.out.println("MyClass.call called with " + arg);
            return arg * 5;
        }
    }

    static private class Person {
        public String firstName;
        public String lastName;

        public Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        //ICallable c = new ICallable();
        //ICallable c = new MyClass();
//        ICallable c = new ICallable() {
//            @Override
//            public void call(int arg) {
//                System.out.println("Inline implementation called");
//                System.out.println(getClass().getName());
//            }
//        };

        ICallable c = (arg) -> {
            System.out.println(arg);
            return arg * 3;
        };
        //ICallable c = arg -> arg * 2;

        c.call(5);

        List<Person> people = new ArrayList<>();
        people.add(new Person("Ivan", "Ivanov"));
        people.add(new Person("Petar", "Petrov"));
        people.add(new Person("Georgi", "Georgiev"));

//        people.sort(new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                return o1.firstName.compareTo(o2.firstName);
//            }
//        });
        people.sort((o2, o1) -> o1.firstName.compareTo(o2.firstName));
        people.forEach(p -> System.out.println(p));

        List<String> sortedNames = people
                .stream()
                .sorted(Comparator.comparing(o -> o.firstName))
                .map(p -> p.firstName + " " + p.lastName)
                .collect(Collectors.toList());

        sortedNames.forEach(n -> System.out.println(n));

    }



}
