package org.elsys.oop.packages;

//import org.elsys.oop.packages.example.*;
import org.elsys.oop.packages.example.DrivingLicense;
import org.elsys.oop.packages.example.Person;

import java.sql.Array;
import java.util.*;
import java.util.function.Consumer;

//import static org.elsys.oop.packages.example.Person.foo;
//import static org.elsys.oop.packages.example.Person.*;

public class Main {
    public static void main(String[] args) {

//        System.out.println("Hello world!");

//        Person p = new Person();
//        foo();

        Person[] people = {
                new Person("Petar", 10),
                new Person("Ivan", 20),
                new Person("Bobi", 5)
        };

//        Arrays.sort(people);
//        Arrays.sort(people, new Person.CompareNames());
//        Arrays.sort(people, Comparator.comparingInt(Person::getAge));
        Arrays.sort(people, Comparator.comparing(Person::getName));


        for(int i = 0; i < people.length; i++)
            System.out.println(people[i]);


        DrivingLicense[] dl = {
          new DrivingLicense(1, new Person("Petko", 25)),
        new DrivingLicense(2, new Person("Galabin", 18)),
        };

        Arrays.sort(dl, Comparator.comparing(DrivingLicense::getOwner));

//        for(int i = 0; i < dl.length; i++)
//            System.out.println(dl[i]);

        System.out.println(Arrays.toString(dl));

        List<Person> pp = new ArrayList();
        for(int i = 0; i < pp.size(); i++) {
            // ...
            System.out.println(pp.get(i));
        }
        for(Person p : pp) {
            // ..
            System.out.println(p);
        }
        pp.forEach(new Consumer<Person>() {
            @Override
            public void accept(Person person) {
                System.out.println(person);
            }
        });
        pp.forEach(person -> System.out.println(person));
    }
}