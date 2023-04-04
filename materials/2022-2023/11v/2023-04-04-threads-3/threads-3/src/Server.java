public class Server implements Runnable {
    public Thread cookThread;
    public Cook cook;

    public Server(Thread cookThread, Cook cook) {
        this.cookThread = cookThread;
        this.cook = cook;
    }
    @Override
    public void run() {
        try {
            Object order = new Object();
            System.out.printf("Server: New order " + order);

//            cook.order = order;
//            cook.startCooking(); ??
            cook.order = order;
            cookThread.interrupt();
            System.out.println("Server: Passed order to cook");

    //        cook.waitToFinish(); ??
            synchronized (order) {
                order.wait();
                System.out.printf("Server: Order is cooked");
                cook.order = null;
            }

            System.out.println("Server: Done");
        } catch (InterruptedException e) {
            return;
        }
    }
}
