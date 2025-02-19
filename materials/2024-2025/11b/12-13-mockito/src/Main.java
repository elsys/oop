import java.util.function.Consumer;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public void forEach(Consumer fn) {
        fn.accept(123);
        fn.accept(456);
    }

    public int foo(Function<Integer, Integer> fn) {
        return fn.apply(123) * 2;
    }
}