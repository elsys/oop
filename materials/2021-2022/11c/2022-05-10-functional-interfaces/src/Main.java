import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    static private class MyClass implements ICallable {
        private int a = 5;

        public int getA() {
            return a;
        }

        @Override
        public int call(int arg) {
            System.out.println("MyClass.call has been called with " + arg);
            System.out.println("MyClass.a = " + a);
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

    /*static private class MyClass2 implements ICallable {
        private int a = 5;
        @Override
        public void call(int arg) {
            System.out.println("MyClass.call has been called with " + arg);
            System.out.println(a);
        }
    }*/

    public static void main(String[] args) {
//        ICallable c = new ICallable();
        ICallable c = new MyClass();
        //c = new MyClass2();
        c = new ICallable() {
            @Override
            public int call(int arg) {
                System.out.println("Inline ICallable definition");
                System.out.println(this.getClass().getName());
                return arg * 10;
            }
        };
        c = (arg) -> {
            System.out.println("Inline ICallable definition");
            //System.out.println(this.getClass().getName());
            return arg * 2;
        };
        c = arg -> arg * 3;
        c.call(5);

        if(c instanceof MyClass) {
//            c.getClass().getName() == "MyClass"
            ((MyClass) c).getA();
        }



        //List<Integer> l = new LinkedList<>();
        List<Person> people = new ArrayList<>();
        people.add(new Person("Ivan", "Ivanov"));
        people.add(new Person("Ivan", "Petrov"));
        people.add(new Person("Ivan", "Ivaylov"));
        people.add(new Person("Ivana", "Trendafilova"));

//        people.sort(new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                return o1.firstName.compareTo(o2.firstName);
//            }
//        });
        people.sort((o1, o2) -> o1.firstName.compareTo(o2.firstName));
        people.forEach((p) -> System.out.println(p));
        List<String> names = people
                .stream()
                .sorted(Comparator.comparing(p -> p.firstName + p.lastName))
                .map((p) -> p.firstName + " "  + p.lastName)
                .collect(Collectors.toList());
    }
}
