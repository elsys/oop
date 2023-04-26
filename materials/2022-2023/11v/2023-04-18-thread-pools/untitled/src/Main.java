import java.util.Random;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        Runnable r1 = () -> {
            System.out.println("Task started");
            try {
                Thread.sleep(Math.abs(new Random().nextInt() + 500) % 5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName());
        };

        /*Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r1);
        t1.start();
        t2.start();*/

//        Executor ex = Executors.newFixedThreadPool(2);
//        Executor ex = Executors.newSingleThreadExecutor();
//        Executor ex = Executors.newCachedThreadPool();
//        Executor ex = new ThreadPoolExecutor(
//                2,
//                4,
//                100L,
//                TimeUnit.MILLISECONDS,
//                new SynchronousQueue<Runnable>());
        ExecutorService ex = Executors.newFixedThreadPool(2);
        ex.execute(r1);
        ex.execute(r1);
        ex.execute(r1);
        ex.execute(r1);
        ex.execute(r1);

        ex.shutdown();
        System.out.println("Shutdown called");
//        ex.execute(r1);
//        ex.shutdownNow();

        if(!ex.isShutdown())
            try {
                ex.awaitTermination(200L, TimeUnit.MILLISECONDS);
                if(!ex.isShutdown())
                    ex.shutdownNow();
            } catch (InterruptedException e) {
                ex.shutdownNow();
            }
    }
}
