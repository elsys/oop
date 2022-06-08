import java.util.LinkedList;
import java.util.List;

public class Receiver implements Runnable {
    private List<Character> data = new LinkedList<>();
    private Sender sender;

    public void setSender(Sender sender) {
        this.sender = sender;
    }

    @Override
    public void run() {
        try {
            while(true) {
                System.out.println("Receiver waiting for data");
                synchronized (this) {
                    wait();
                }
                System.out.println("Receiver data ready");
                System.out.println("Receiver start processing");
                Thread.sleep(1000);
                System.out.println(data);
                data.clear();
                if(Thread.interrupted()) {
                    throw new InterruptedException();
                }
                System.out.println("Receiver processing ready");
                synchronized (sender) {
                    sender.notify();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public void send(char c) {
      data.add(c);
    }
}
