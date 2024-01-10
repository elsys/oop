import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.BaseStream;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static class User {
        public String firstName;
        public String lastName;
        public int age;

        public User(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 1, 2, 4};

        BaseStream foo = Arrays.stream(arr);
        Object[] res = Arrays.stream(arr)
                .filter(a -> a > 3)
                .sorted()
                .map(a -> a * 2)
                .mapToObj(a -> "foo-" + a)
                .toArray();

        System.out.println(Arrays.toString(res));

        Random rand = new Random();
        List<User> users = Stream.generate(() ->
                new User("Name" + rand.nextInt(), "Name" + rand.nextInt(), rand.nextInt())
            )
            .limit(10)
            .toList();

        System.out.println(users);

        List<User> res2 = users.stream()
//            .sorted((a, b) -> a.firstName.compareTo(b.firstName))
            .sorted(Comparator.comparing(a -> a.firstName))
            .skip(10)
            .limit(5)
            .toList();

        System.out.println(res2);

        Optional<User> bar = users.stream()
                .findFirst();
//        bar.ifPresent(System.out::println);
        if(!bar.isEmpty())
            System.out.println(bar.get());

//        users.stream()
//                .collect(Collectors.toList())
//                .collect(new Collector<User, Object, Object>() {
//                    @Override
//                    public Supplier<Object> supplier() {
//                        return null;
//                    }
//
//                    @Override
//                    public BiConsumer<Object, User> accumulator() {
//                        return null;
//                    }
//
//                    @Override
//                    public BinaryOperator<Object> combiner() {
//                        return null;
//                    }
//
//                    @Override
//                    public Function<Object, Object> finisher() {
//                        return null;
//                    }
//
//                    @Override
//                    public Set<Characteristics> characteristics() {
//                        return null;
//                    }
//                })
    }
}
