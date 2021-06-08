import java.lang.reflect.Executable;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class Main {
    private static class MyRunnable implements Runnable {
        @Override
        public void run() {
            try {
                for(int i=0; i<5; i++) {
                    System.out.println(
                            Thread.currentThread().getName() +
                                    " " +
                                    i
                    );
                    Thread.sleep(1000);
                    //Thread.currentThread().isInterrupted()
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(
                    Thread.currentThread().getName() +
                    " is finished"
            );
        }
    }

    private static class MyCallable implements Callable<Integer> {
        private static Random rand = new Random();

        @Override
        public Integer call() throws Exception {
            Thread.sleep(1000);
            return rand.nextInt();
        }
    }

    public static void main(String[] args)
            throws InterruptedException, ExecutionException {
        ExecutorService ex =
                Executors.newFixedThreadPool(4);

        /*ex.submit(new MyRunnable());
        ex.submit(new MyRunnable());
        ex.submit(new MyRunnable());
        ex.submit(new MyRunnable());
        ex.submit(new MyRunnable());
        ex.submit(new MyRunnable());
        Future<Integer> result = ex.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(1000);
                return 15;
            }
        });

        int finalResult = result.get();
        System.out.println(finalResult);*/

        List<MyCallable> tasks = new LinkedList<>();
        for(int i=0; i< 15; i++) {
            tasks.add(new MyCallable());
        }

        /*List<Future<Integer>> results = ex.invokeAll(tasks);
        results
                .stream()
                .forEach((res) -> {
            try {
                System.out.println(res.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });*/
        Integer result = ex.invokeAny(tasks);

        //ex.shutdown();
        //ex.shutdownNow();

        ex.shutdown();
        ex.awaitTermination(2, TimeUnit.SECONDS);
        if(ex.isShutdown())
            ex.shutdownNow();
    }
}
