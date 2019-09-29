package org.elsys;

public class Student {
    private long id;
    private String FirstName;
    private String LastName;

    public Student(){
        this.id = 0;
        this.FirstName = "";
        this.LastName = "";
    }

    public Student(long id, String fName, String lName){
        this.id = id;
        this.FirstName = fName;
        this.LastName = lName;
    }

    public String getFirstName(){
        return this.FirstName;
    }

    public String getLastName(){
        return this.LastName;
    }

    public long getId(){
        return this.id;
    }

    @Override
    public String toString(){
        return "Student: " + this.id + " "
                + this.FirstName + " "
                + this.LastName;
    }

    @Override
    public boolean equals(Object obj){
        if(obj == null) {
            return false;
        }

        Student other = (Student)obj;
        return this.id == other.id
                && other.FirstName.equals(this.FirstName)
                && this.LastName.equals(other.LastName);
    }

    @Override
    public int hashCode(){
        int result = 0;
        final int prime = 17;

        result = (int)id
                + FirstName.hashCode() * prime
                + LastName.hashCode();

        return result;
    }
}
