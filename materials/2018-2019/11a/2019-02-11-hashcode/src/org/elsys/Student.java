package org.elsys;

import java.util.LinkedList;

public class Student {
    private long id;
    private String FirstName;
    private String LastName;
    private LinkedList<Double> grades;

    public Student(){
        this.id = 0;
        this.FirstName = this.LastName = "";
        this.grades = new LinkedList<Double>();
    }

    public Student(long id, String fName, String lName){
        this.id = id;
        this.FirstName = fName;
        this.LastName = lName;
        this.grades = new LinkedList<Double>();
    }

    public long getId(){
        return this.id;
    }

    public String getFirstName(){
        return this.FirstName;
    }

    public String getLastName(){
        return this.LastName;
    }

    @Override
    public String toString(){
        return "Student: "
                + id + " "
                + FirstName + " "
                + LastName;
    }

    @Override
    public boolean equals(Object obj){

        if(obj == null) {
            if (this != null)
                return false;
            else
                return true;
        } else if (this == null)
            return false;

        Student other = (Student)obj;

        if (id != other.id)
            return false;

        if (!FirstName.equals(other.FirstName))
            return false;

        if (!LastName.equals(other.LastName))
            return false;

        return true;
    }

    @Override
    public int hashCode(){
        int result = 0;
        final int prime = 31;

        result = FirstName.hashCode() * prime
                + LastName.hashCode()
                + (int)id;

        return result;
    }

    public void addGrade(Double grade){
        this.grades.add(grade);
    }

    public Double avarageGrade(){
        Double result = 0d;

        for (Double grade:grades) {
            result += grade;
        }

        return result / grades.size();
    }
}
