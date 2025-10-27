import java.util.Objects;

public class Student extends Person {
    private String grade;

    public Student(String name, int idNumber, String grade) {
        super(name, idNumber);
        this.grade = grade;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Objects.equals(grade, student.grade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), grade);
    }

    @Override
    public String toString() {
        return "Student{" +
                "grade='" + grade + '\'' +
                ", name='" + name + '\'' +
                ", idNumber=" + idNumber +
                '}';
    }
}
