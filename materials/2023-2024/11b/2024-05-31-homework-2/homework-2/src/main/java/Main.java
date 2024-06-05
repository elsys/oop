import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    ExecutorService ex = Executors.newFixedThreadPool(5);
    public void main() {
//        Foo f1 = Foo.factoryMethod1();
//        Foo f2 = Foo.factoryMethod2();
        ex.execute(() -> {});
        ex.execute(() -> {});
        ex.execute(() -> {});
    }
}
