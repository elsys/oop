import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main1(String[] args) {
        System.out.println("Main started");
        Thread t1 = new Thread(() -> {
            System.out.println("Thread 1 started");
            Thread t2 =  new Thread(() ->
            {
                System.out.println("Thread 2 started");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    System.out.printf("Thread 2 interrupted");
                }
                System.out.println("Thread 2 finished");
            }
            );
            Thread t3 =  new Thread(() ->
            {
                System.out.println("Thread 3 started");
                try {
                    Thread.sleep(7000);
                } catch (InterruptedException e) {
                    System.out.printf("Thread 3 interrupted");
                }
                System.out.println("Thread 3 finished");
            }
            );

            t2.start();
            t3.start();

            try {
                t2.join();
                t3.join();
            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
                System.out.println("Thread 1 interrupted");
                t2.interrupt();
                t3.interrupt();
            }
            System.out.println("Thread 1 finished");

        });
      //  t1.run();
        t1.start();

        try {
            t1.join(3000);
        } catch (InterruptedException e) {
            System.out.println("Main interrupted");
            t1.interrupt();
            throw new RuntimeException(e);
        }
        if(t1.isAlive())
            t1.interrupt();
        System.out.println("Main finished");
    }

    private static class Philospher implements Runnable {
        private Philospher next = null;
        private Object fork = null;

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " is starting");
            try {
                while (true) {
                    if (this.fork == null)
                        synchronized (this) {
                            System.out.println(Thread.currentThread().getName() + " is waiting for fork");
                            this.wait();
                        }
                    System.out.println(Thread.currentThread().getName() + " is eating");
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + " is passing the fork");
                    next.giveFork(fork);
                    fork = null;
                }
            } catch(InterruptedException ex) {
                System.out.println(Thread.currentThread().getName() + " is exiting");
            }
        }

        public void giveFork(Object fork) {
            synchronized (this) {
                this.fork = fork;
                System.out.println(Thread.currentThread().getName() + " got the fork");
                this.notify();
            }
        }

        public void setNext(Philospher philospher) {
            next = philospher;
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Object fork = new Object();
        List<Philospher> ph = new ArrayList<>(4);
        for(int i = 0; i < 4; i++)
            ph.add(new Philospher());

        for(int i = 0; i < 3; i++)
            ph.get(i).setNext(ph.get(i+1));
        ph.get(3).setNext(ph.get(0));

        List<Thread> t = new ArrayList<>(4);
        for(int i = 0; i < 4; i++) {
            t.add(new Thread(ph.get(i)));
            t.get(i).start();
        }

        Thread.sleep(100);
        ph.get(0).giveFork(fork);
    }
}
