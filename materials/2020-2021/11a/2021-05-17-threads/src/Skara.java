public class Skara implements Runnable {
//public class Skara extends Thread {
    private int steakCount = 0;
    private int steakMax;

    public Skara(int steakMax) {
        this.steakMax = steakMax;
    }

    Object lock = new Object();

    public void addSteak() {
//        synchronized(lock) {
        synchronized(this) {
            if(steakCount >= steakMax) return;
            steakCount = steakCount + 1;
            System.out.println("Steak count is " + steakCount);
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Sleep after add finished");
    }

    public synchronized void removeSteak() {
        if(steakCount <= 0) return;

        steakCount--;
        System.out.println("Steaks reduced to " + steakCount);
    }

    @Override
    public void run() {
        try {
            while(true) {
                while (steakCount < steakMax) {
                    System.out.println("Not enough steaks");
                    Thread.sleep(1 * 1000);
                }

                System.out.println("Bake the steaks...");
                Thread.sleep(5 * 1000);
                synchronized (this) {
                    steakCount -= steakMax;
                }
                System.out.println("The steaks are ready");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
