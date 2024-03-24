import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {
    public static class MyThread1 implements Runnable {
        @Override
        public void run() {
            try {
               while(true) {
                    System.out.println(
                            Thread.currentThread().getName() + " is awake"
                    );
                    Thread.sleep(2000);
                    if(Thread.interrupted())
                        throw new InterruptedException();
                }
            } catch (InterruptedException e) {
//                System.out.println(
//                        Thread.currentThread().getName() + " interrupted"
//                );
            }

            try {
                while(true) {
                    System.out.println(
                            Thread.currentThread().getName() + " is awake again"
                    );
                    Thread.sleep(2000);
                }
            } catch (InterruptedException e) {}

            System.out.println(
                    Thread.currentThread().getName() + " is clean and closing"
            );
        }
    }

    public static class PrimeFinder implements Runnable {
        @Override
        public void run() {
            for(int i = 100000000; i < 1000000000; i++) {
                boolean isPrime = true;
                for(int j = 2; j < i; j++) {
                    if(i % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
                System.out.println(
                        i + " is prime: " + isPrime
                );

                if(Thread.interrupted())
                    return;
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
//        Thread t1 = new Thread(new MyThread1());
//        t1.start();
//
//        System.out.println("Main sleeps");
//        Thread.sleep(4000);
//        System.out.println("Main is ready");
//
////        t1.stop();
//        t1.interrupt();


//        Thread t2 = new Thread(new PrimeFinder());
//        t2.start();

//        Thread.sleep(4000);

//        t2.join(4000);
//        if(t2.isAlive()) {
//            t2.interrupt();
//            t2.join(1000);
//            if(t2.isAlive())
//                t2.stop();
//        }


//        new ThreadPoolExecutor();
//        new Executor() {
//            @Override
//            public void execute(Runnable command) {
//
//            }
//        };
        Executor ex = Executors.newSingleThreadExecutor();
        ex.execute(new PrimeFinder());

    }
}
