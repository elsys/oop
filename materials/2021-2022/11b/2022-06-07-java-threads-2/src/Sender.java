public class Sender implements Runnable {
    private final String data = "Hello";
    private Receiver receiver;

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void run() {
        try {
            while(true) {
                System.out.println("Sender is sending...");
                for (char c : data.toCharArray()) {
                    receiver.receive(c);
                    Thread.sleep(200);
                }
                System.out.println("Sender is done sending");
                synchronized (receiver) {
                    receiver.notify();
                }

                System.out.println("Sender is waiting for processing");
                synchronized (this) {
                    wait();
                }
                System.out.println("Sender is done waiting");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
