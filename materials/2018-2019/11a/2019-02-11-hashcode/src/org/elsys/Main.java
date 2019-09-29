package org.elsys;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
	    Student veso = new Student(1, "Veselin", "Rusinov");
        Student veso2 = new Student(1, "Rusinov", "Veselin");

        ArrayList<Student> students = new ArrayList<Student>();
        students.add(veso);

        students.add(new Student(2, "Ivan", "Ivanov"));

        System.out.println(students.contains(new Student(1, "Veselin", "Rusinov")));
        System.out.println(students.get(0));

        LinkedList<Student> studentLinkedList = new LinkedList<Student>();
        studentLinkedList.add
                (new Student(2, "Pesho", "Petrov"));

        System.out.println(veso.hashCode());
        System.out.println(veso2.hashCode());
        System.out.println(students.get(1).hashCode());

        HashSet<Student> studentHashSet
                = new HashSet<Student>();

        studentHashSet.add(veso);
        studentHashSet.add(new Student(5, "A", "B"));

        System.out.println(studentHashSet.toString());

        veso.addGrade(5.0);
        veso.addGrade(4.5);
        veso.addGrade(6.0);

        System.out.println(veso.avarageGrade());
    }
}
