import java.util.Objects;

public class Main {
    private static class Person {
        public String name;
        public int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Person person = (Person) o;

            if (age != person.age) return false;
            return Objects.equals(name, person.name);
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + age;
            return result;
        }
    }

    public static void main(String[] args) {
//        new BST.TreeNode(5);
        BST bst = new BST();
        try {
//            bst.add(4);
//            bst.add(5);
//            bst.add(6);
//            bst.add(4);
//            bst.add(3);
            bst.add(new Person("Ivan", 20));
            bst.add(new Person("Petar", 22));
            bst.add(new Person("Ivan", 20));
            bst.add(new Person("Mitko", 2));
            bst.add(3);
            bst.add("HELLO");
        } catch (BST.DuplicateValueException e) {
            System.out.println(e.duplicateValue);
            e.printStackTrace();
        }
    }
}
