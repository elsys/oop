import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main extends Object {
    public static class MyComparator implements Comparator<Person> {
        @Override
        public int compare(Person o1, Person o2) {
            if(o1.name.compareTo(o2.name) != 0) return o1.name.compareTo(o2.name);
            return Integer.compare(o1.idNumber, o2.idNumber);
        }
    }


    public static void main(String[] args) {
//        Map<String, String> s1 = new TreeMap<>();
//        s1.put("asd", "asd");

        Person p1 = new Person("Ivan", 1234);
        Person p1_1 = new Person("Ivan", 1234);
        Person p2 = new Person("Petar", 5678);
        Student s1 = new Student("Ivan", 1234, "11b");

        System.out.println(p1 == p2);
        System.out.println(p1.equals(p2));
        System.out.println(p1 == p2);
        System.out.println(p1.equals(p1_1));
        System.out.println(p1.equals(s1));
        System.out.println(s1.equals(p1));

        System.out.println(p1);
        System.out.println(s1);

        PersonEntry pe1 = new PersonEntry("Ivan", 1234);
        PersonEntry pe1_1 = new PersonEntry("Ivan", 1234);

        System.out.println(pe1 == pe1_1);
        System.out.println(pe1.equals(pe1_1));
        System.out.println(pe1);
        System.out.println(pe1.name() + pe1.idNumber());

        Comparator<Person> cmp1 = new MyComparator();
        Comparator<Person> cmp2 = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if(o1.name.compareTo(o2.name) != 0) return o1.name.compareTo(o2.name);
                return Integer.compare(o1.idNumber, o2.idNumber);
            }
        };
        Comparator<Person> cmp3 = (o1, o2) -> {
            if(o1.name.compareTo(o2.name) != 0) return o1.name.compareTo(o2.name);
            return Integer.compare(o1.idNumber, o2.idNumber);
        };

        Comparator<Person> cmp4 = (o1, o2) ->
            Integer.compare(o1.idNumber, o2.idNumber);
        Comparator<Person> cmp5 = Comparator.comparingInt(o -> o.idNumber);

    }
}

