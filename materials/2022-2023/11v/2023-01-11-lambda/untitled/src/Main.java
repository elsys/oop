import java.util.LinkedList;
import java.util.List;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        Demo d = new Demo() {
//            int a;
            @Override
            public void foo(int a) {
                System.out.println("Demo1 " + a);
            }
        };

        Demo d2 = a -> {
            System.out.println("Demo2 " + a);
            System.out.println("Hello");
        };

        d.foo(2);
        d2.foo(5);

        List<Integer> arr = new LinkedList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);

        arr.forEach(a -> System.out.println(a));
        arr.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer a) {
                System.out.println(a);
            }
        });

        Supplier<Integer> s = () -> {
            System.out.println("I'm supplier");
            return 12;
        };
        Consumer<Integer> c = (a) -> {
            System.out.println(a);
//            return 5;
        };
        Function<Integer, String> f = (a) -> a.toString();
        BiFunction<Integer, String, String> bf = (a, b) -> b + a;
        Predicate<Integer> p = (a) -> a > 5;
        UnaryOperator<Integer> o = (a) -> a + 5;

        arr
            .stream()
            .map(a -> a * 2)
            .filter(a -> a >= 2)
            .forEach(a -> System.out.println(a));
    }
}








