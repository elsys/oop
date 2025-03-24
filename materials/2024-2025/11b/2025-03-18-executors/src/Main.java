import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        Executor ex = new Executor() {
//            @Override
//            public void execute(Runnable command) {
//
//            }
//        };
//        Executor ex = new ThreadPoolExecutor(
//                2,
//                10,
//                100,
//                TimeUnit.MILLISECONDS,
//                new ArrayBlockingQueue<>(...)
//        );
//        ExecutorService ex = Executors.newSingleThreadExecutor();
//        Executor ex2 = Executors.newFixedThreadPool(3);
//        Executor ex3 = Executors.newScheduledThreadPool(3);
        ExecutorService ex4 = Executors.newCachedThreadPool();

//        for(int i = 0; i < 5; i++)
//            ex4.execute(() -> {
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    System.out.println(e);
//                }
//                System.out.println("Thread done");
//            });

        Future<Integer> res = ex4.submit(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            return new Random().nextInt();
        });

        System.out.println(res.get());

        List<Future<Object>> results = ex4.invokeAll(Stream.generate(() -> {
            return () -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
                return new Random().nextInt();
            }
        }).limit(5).toList());

        ex4.shutdown();
        ex4.awaitTermination(1500, TimeUnit.MILLISECONDS);
        if(!ex4.isTerminated())
            ex4.shutdownNow();
    }
}