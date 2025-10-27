import java.util.Objects;

public class Person {
    protected final String name;
    protected final int idNumber;

    public Person(String name, int idNumber) {
        this.name = name;
        this.idNumber = idNumber;
    }

    public String getName() {
        return name;
    }

    public int getIdNumber() {
        return idNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return idNumber == person.idNumber && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, idNumber);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", idNumber=" + idNumber +
                '}';
    }
}
