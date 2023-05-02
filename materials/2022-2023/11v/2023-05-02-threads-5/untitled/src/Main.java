import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public volatile static int counter = 0;
    public static AtomicInteger counter2 =
            new AtomicInteger(2);

    public static class MyWriter implements Runnable {
        @Override
        public void run() {
            while(Main.counter < 100) {
                Main.counter++;
                Main.counter2.addAndGet(1);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    public static class MyReader implements Runnable {
        @Override
        public void run() {
            while(Main.counter < 100) {
                System.out.println(
                        Thread.currentThread().getName() + " " +
                                Main.counter
                );
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    public static void main(String[] args) {
//        ExecutorService ex = Executors.newFixedThreadPool(5);
//        ex.submit(new MyWriter());
//        ex.submit(new MyReader());
//        ex.submit(new MyReader());
//        ex.submit(new MyReader());
//        ex.submit(new MyReader());
//
//        ex.shutdown();
//        try {
//            ex.awaitTermination(1000L, TimeUnit.DAYS);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println(counter);

        int sum = Stream.iterate(1, (a) -> a + 1)
                .limit(10000)
                .parallel()
                .map((a) -> a * 2)
                .collect(Collectors.summingInt((a) -> a));

        System.out.println(sum);
    }
}
