package org.elsys.serializer.main;

import org.elsys.serializer.JSONSerializer;

import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        Student student = new Student();
        student.setFirstName("Bruce");
        student.setFathersName("Thomas");
        student.setLastName("Wayne");
        student.setGrades(Arrays.asList(4, 5, 6, 4));

        JSONSerializer serializer = new JSONSerializer();
        String result = serializer.serialize(student);

        System.out.println(result);
    }
}