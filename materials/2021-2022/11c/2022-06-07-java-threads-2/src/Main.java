public class Main {
    public static void main(String[] args) throws InterruptedException {
        Sender s = new Sender();
        Receiver r = new Receiver();

        s.setReceiver(r);
        r.setSender(s);

        Thread sThread = new Thread(s, "SENDER");
        Thread rThread = new Thread(r, "RECEIVER");

        sThread.start();
        rThread.start();

        Thread.sleep(5000);
        sThread.interrupt();
        rThread.interrupt();
    }
}

