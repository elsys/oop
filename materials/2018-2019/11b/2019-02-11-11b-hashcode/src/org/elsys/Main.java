package org.elsys;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
	    Student veselin =
                new Student(1, "Veselin", "Rusinov");
	    System.out.println(veselin);

        ArrayList<Student> studentArrayList = new ArrayList<Student>();
        studentArrayList.add(veselin);
        studentArrayList.add(new Student(2, "Ivan", "Petrov"));
        studentArrayList.add(null);
        System.out.println(studentArrayList);
        System.out.println(
                studentArrayList.
                        contains(new Student(1, "Veselin","Rusinov")));

        LinkedList<Student> studentLinkedList = new LinkedList<Student>();
        studentLinkedList.add(veselin);
        studentLinkedList.add(new Student(2, "Ivan", "Petrov"));

        Student veselin2 =
                new Student(1, "Rusinov", "Veselin");

        System.out.println(veselin.hashCode());
        System.out.println(veselin2.hashCode());
        System.out.println(studentLinkedList.get(1).hashCode());

        HashSet<Student> studentHashSet = new HashSet<Student>();
        studentHashSet.add(veselin);
        
        System.out.println(studentHashSet);
    }
}
