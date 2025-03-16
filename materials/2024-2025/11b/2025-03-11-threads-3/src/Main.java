import java.util.Random;

public class Main {
    public static class Producer implements Runnable {
        public int data = 0;

        @Override
        public void run() {
            try {
                while(true) {
                    Thread.sleep(1000);
                    data = new Random().nextInt();
                    synchronized (this) {
                        this.notify();
                    }
                }
            } catch (InterruptedException e) {}
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Producer prod = new Producer();
        Thread prodT = new Thread(prod);

        Thread consT = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while(true) {
                        synchronized (prod) {
                            prod.wait();
                            int data = prod.data;
                            prod.data = 0;
                            System.out.println(data);
                        }
                    }
                } catch (InterruptedException e) {}
            }
        });

        prodT.start();
        consT.start();

        Thread.sleep(5000);

        prodT.interrupt();
        consT.interrupt();
        prodT.join();
        consT.join();
    }
}