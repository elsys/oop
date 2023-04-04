public class Cook implements Runnable {
    public Object order;

    @Override
    public void run() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.printf("Cook: Got order");
        }

        System.out.println("Cook: Cooking");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            return;
        }
        System.out.println("Cook: Done cooking");

        synchronized (order) {
            order.notify();
        }
    }

//    public void takeOrder(Object order) throws InterruptedException {
//        this.order = order;
//
//        Thread.sleep(1000);
//
//        order.notify();
////        order.notifyAll();
//    }
}
