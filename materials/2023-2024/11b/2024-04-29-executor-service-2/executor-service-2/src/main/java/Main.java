import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static class MyTask implements Callable {
        private int task;

        public MyTask(int task) {
            this.task = task;
        }

//        @Override
//        public void run() {
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }

        @Override
        public Integer call() throws Exception {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            return task;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        ExecutorService ex = Executors.newFixedThreadPool(2);
//        ExecutorService ex = Executors.newCachedThreadPool();
        ExecutorService ex = Executors.newWorkStealingPool()

        List<Future<Integer>> results = new LinkedList<>();
        for(int i = 0; i < 10; i++) {
//            ex.execute(new MyTask(i));
//            Future<Integer> res = ex.submit(new MyTask(i));
//            Integer finalRes = res.get();
//            System.out.println(finalRes);
            results.add(ex.submit(new MyTask(i)));
        }

        results.stream().map(future -> {
            try {
                return future.get();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }).forEach(System.out::println);

        ex.shutdown();
    }
}
