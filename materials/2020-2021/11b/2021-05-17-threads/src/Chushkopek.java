public class Chushkopek implements Runnable {
//public class Chushkopek extends Thread {
    private int capacity;
    private int count = 0;

    public volatile int iterCount = 0;

    public Chushkopek(int capacity) {
        this.capacity = capacity;
    }

    private Object lock = new Object();

    public void addChushka() {
        //synchronized(lock) {
        synchronized(this) {
            if(count >= 5) return;
            count++;
            System.out.println("Count is " + count);
        }
        System.out.println("outside the synchronized block");
    }

    public synchronized void removeChushka() {
        if(count <= 0) return;

        count--;
        System.out.println("Count " + count);
    }

    @Override
    public void run() {
        System.out.println("I am the chushkopek");
        try {
            while(true) {
                iterCount++;

                while (count < capacity) {
                    System.out.println("Not enough chushki. Sleeping...");
                    Thread.sleep(1 * 1000);
                }

                synchronized (this) {
                    System.out.println("Start cooking..");
                    Thread.sleep(3 * 1000);
                    count -= capacity;
                    System.out.println("Done cooking");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
