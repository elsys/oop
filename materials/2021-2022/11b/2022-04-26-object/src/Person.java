import java.util.Objects;

public class Person implements Comparable {
    public String firstName;
    public String lastName;
    public int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public String toString() {
        return super.toString() +
                " {firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
//        return age == person.age
//                && Objects.equals(firstName, person.firstName)
//                && Objects.equals(lastName, person.lastName);
        return hashCode() == person.hashCode();
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age);
    }

    @Override
    public int compareTo(Object o) {
        Person other = (Person)o;

        return other.age - age;
    }
}
