public class Sender implements Runnable {
    private final String data = "Hello";
    private Receiver receiver;

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("Sender is sending");
                for (int i = 0; i < data.length(); i++) {
                    char c = data.charAt(i);
                    receiver.send(c);
                    Thread.sleep(100);
                }
                System.out.println("Sender done sending");
                synchronized (receiver) {
                    receiver.notify();
                }
                System.out.println("Sender waiting for processing");
                synchronized (this) {
                    wait();
                }
                System.out.println("Sender done waiting");
            }
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
    }
}
