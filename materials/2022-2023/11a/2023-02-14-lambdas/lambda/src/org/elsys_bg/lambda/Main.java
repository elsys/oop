package org.elsys_bg.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.logging.Filter;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("p1", 12, 6));
        personList.add(new Person("p2", 18, 12));
        personList.add(new Person("p3", 25, 18));

        action(personList);
        action5(personList, new Tester1());
        action5(personList, new Tester2());

        action5(personList, new Tester() {
            @Override
            public boolean test(Person p) {
                return p.getAge() < 18;
            }
        });

        action5(personList, (p) -> {
            int v = 5;
            if(p.getName().isEmpty()) {
                return p.getAge() < 18;
            } else {
                return false;
            }
        });
        action5(personList, p -> p.isOldEnough());
        action5(personList, Person::isOldEnough);

        action5(personList, Main::test);

        action5_1(personList, p -> p.isOldEnough());


        action6(personList, (p1, p2) -> p1.getAge() - p2.getAge() > 0);
        //(var, var, var) -> { return result; }
        //(p) p
        //p -> p.getAge() < 18
     }

     public void doStaff() {
         List<Person> personList = new ArrayList<>();
         personList.add(new Person("p1", 12, 6));
         personList.add(new Person("p2", 18, 12));
         personList.add(new Person("p3", 25, 18));

         action5(personList, this::test2);
     }

     public static boolean test(Person p) {
        return true;
     }

    public boolean test2(Person p) {
        return true;
    }

     public static void action(List<Person> persons) {
        for(Person p : persons) {
            if(p.getAge() < 18) {
                System.out.println(p);
            }
        }
     }

//    public static void action2(List<Person> persons) {
//        for(Person p : persons) {
//            if(14 < p.getAge() && p.getAge() < 18) {
//                System.out.println(p);
//            }
//        }
//    }
//
//    public static void action3(List<Person> persons) {
//        for(Person p : persons) {
//            if(20 < p.getAge() && p.getAge() < 30) {
//                System.out.println(p);
//            }
//        }
//    }

    public static void action4(List<Person> persons, int min, int max) {
        for(Person p : persons) {
            if(min < p.getAge() && p.getAge() < max) {
                System.out.println(p);
            }
        }
    }

    public static void action5(List<Person> persons, Tester filter) {
        for(Person p : persons) {
            if(filter.test(p)) {
                System.out.println(p);
            }
        }
    }

    public static <T> void action5_1(List<T> persons, Predicate<T> filter) {
        for(T p : persons) {
            if(filter.test(p)) {
                System.out.println(p);
            }
        }
    }

    public static void action6(List<Person> persons, TesterV2 tester) {
        for(Person p : persons) {
            if(tester.test(p, p)) {
                System.out.println(p);
            }
        }
    }
}