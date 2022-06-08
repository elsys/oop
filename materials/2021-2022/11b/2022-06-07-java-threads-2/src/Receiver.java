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
                System.out.println("Receiver is waiting for data");
                synchronized (this) {
                    wait();
                }
                System.out.println("Receiver has data");

                System.out.println("Receiver is processing");
                Thread.sleep(1000);
                System.out.println(data);
                data.clear();
                System.out.println("Receiver is done");

                if(Thread.interrupted())
                    throw new InterruptedException();

                synchronized (sender) {
                    sender.notify();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void receive(char c) {
        data.add(c);
    }
}
