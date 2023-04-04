import java.util.Random;

public class Producer implements Runnable {
    private int nextVal = 0;
    private Random rand = new Random();

    private void produce() {
        nextVal = rand.nextInt();
        System.out.println(
                Thread.currentThread().getName() + ": produced " + nextVal
        );
    }

    public int getVal() {
        int v = nextVal;
        nextVal = 0;
        return v;
    }

    @Override
    public void run() {
        while(true) {
            produce();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
