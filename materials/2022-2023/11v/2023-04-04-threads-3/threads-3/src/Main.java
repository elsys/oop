public class Main {
    public static void main(String[] args) {
//        Thread t1 = new Thread(new Cook());
//        t1.start();
//
//        try {
////            Thread.sleep(3000);
//            t1.join(3000);
////            t1.stop();
//            if(t1.isAlive()) {
//                t1.interrupt();
//                t1.join();
//            }
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        Cook cook = new Cook();
        Thread cookThread = new Thread(cook);
        Thread serverThread = new Thread(new Server(cookThread, cook));

        cookThread.start();
        serverThread.start();
    }
}

