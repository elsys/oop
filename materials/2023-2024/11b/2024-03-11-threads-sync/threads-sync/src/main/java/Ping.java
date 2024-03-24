import static java.lang.Thread.sleep;

public class Ping implements Runnable {
    public Pong pong;

    public synchronized void ping() {
        System.out.println(
            Thread.currentThread().getName() + ": Ping"
        );
        this.notify();
    }

    @Override
    public void run() {
        try {
           while(true) {
               sleep(1000);
               pong.pong();
               synchronized (this) {
                   this.wait();
               }
           }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
