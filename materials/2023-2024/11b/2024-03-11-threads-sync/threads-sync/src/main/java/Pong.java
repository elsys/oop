import static java.lang.Thread.sleep;

public class Pong implements Runnable {
    public Ping ping;

    public synchronized void pong() {
        System.out.println(
                Thread.currentThread().getName() + ": Pong"
        );
        this.notify();
    }

    @Override
    public void run() {
        try {
            while(true) {
                synchronized (this) {
                    this.wait();
                }
                sleep(1000);
                ping.ping();
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
