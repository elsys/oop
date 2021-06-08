import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class Main {
    private static class MyCounter implements Runnable {
        private static int counter = 0;

        @Override
        public void run() {
            int myCount = ++counter;

            try {
                for(int i=0; i<5; i++) {
                    System.out.println(
                            Thread.currentThread().getName() +
                                    " " +
                                    myCount +
                                    " " +
                                    i
                    );
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class MyCallable implements Callable {
        private static Random r = new Random();
        @Override
        public Integer call() throws Exception {
            System.out.println(Thread.currentThread().getName() +
                    " Callable is running..."
            );
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() +
                    " Callable is done!"
            );
            return r.nextInt();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService ex = Executors.newFixedThreadPool(4);
        //Executors.newWorkStealingPool()
        //((ExecutorService) ex).submit(new MyCounter());
        //((ExecutorService) ex).submit(new MyCounter());
        //((ExecutorService) ex).submit(new MyCounter());
        //((ExecutorService) ex).submit(new MyCounter());
        //((ExecutorService) ex).submit(new MyCounter());

        /*Future<Integer> result = ex.submit(() -> {
            System.out.println("Callable is running...");
            Thread.sleep(1000);
            System.out.println("Callable is done!");
            return 1234;
        });*/

        /*try {
            System.out.println("Result is " + result.get());
        } catch (ExecutionException e) {
            e.printStackTrace();
        }*/

        List<Callable<Integer>> allThings = new ArrayList();
        allThings.add(new MyCallable());
        allThings.add(new MyCallable());
        allThings.add(new MyCallable());
        allThings.add(new MyCallable());
        allThings.add(new MyCallable());
        allThings.add(new MyCallable());
        allThings.add(new MyCallable());
        allThings.add(new MyCallable());

        /*List<Future<Integer>> result = ex.invokeAll(allThings);
        result.stream().forEach((v) -> {
            try {
                System.out.println(v.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });*/

        try {
            Integer result = ex.invokeAny(allThings);
            System.out.println(result);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
//        ((ExecutorService) ex).shutdown();

//        Thread.sleep(1500);
//        ((ExecutorService) ex).shutdownNow();

        /*System.out.println("It's executing...");
        ex.shutdown();
        ex.awaitTermination(2, TimeUnit.SECONDS);
        if(ex.isShutdown())
            ex.shutdownNow();
        System.out.println("Execution is done");*/


        System.out.println("All done");
    }
}
