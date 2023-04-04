import java.util.ArrayList;
import java.util.List;

public class Main {
    private static int counter = 0;

    public synchronized static void increment() {
        counter = counter + 1;
//        counter++;
    }

    public synchronized static void decrement() {
        counter--;
    }

    private static Object lock1 = new Object();
    private static Object lock2 = new Object();
    public static void printMessage() {
        System.out.println("Before sync");
        synchronized(lock1) {
            System.out.println("Hello");
        }
        System.out.println("After sync");
        synchronized(lock2) {
            System.out.println("Goodbye");
            synchronized(lock1) {
                System.out.println("Goodbye2");
    }}}
    public static void foo() {
        synchronized(lock2) {
            System.out.println("foo");
        }
    }

    public static void main(String[] args) {
//        for(int i = 0; i < 1000; i++)
//            increment();
//        Thread t1 = new Thread(() -> {
//            for(int i = 0; i < 1000; i++)
//                increment();
//        });

//        t1.start();
//
//        try {
//            t1.join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

//        List<Thread> threads = new ArrayList<>(5);
//        for(int i = 0; i < 5; i++)
//            threads.add(new Thread(() -> {
//                for(int j = 0; j < 200; j++) {
//                    increment();
//                    try {
//                        Thread.sleep(10);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                }
//            }));
//
//        for(Thread t : threads)
//            t.start();
//
//        try {
//            for(Thread t : threads)
//                t.join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//        System.out.println(counter);

        Producer prod = new Producer();
        Thread p = new Thread(prod);
        Thread c = new Thread(new Consumer(prod));

        p.start();
        c.start();

        try {
            p.join();
            c.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
