package org.elsys.serializer.main;

import org.elsys.serializer.Ignore;
import org.elsys.serializer.MapAs;

import java.util.List;

public class Student {
    @MapAs("sobstveno-ime")
    private String firstName;

    @Ignore
    private String fathersName;

    private String lastName;

    private List<Integer> grades;

    public List<Integer> getGrades() {
        return grades;
    }

    public void setGrades(List<Integer> grades) {
        this.grades = grades;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFathersName() {
        return fathersName;
    }

    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
