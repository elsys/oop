public class Producer implements Runnable {
    public Warehouse warehouse;

    public Producer(Warehouse wh) {
        warehouse = wh;
    }

    @Override
    public void run() {
        System.out.println("Producer started");
        while(true) {
            synchronized (warehouse) {
                if (warehouse.getBoxesCount() < 100) {
                    System.out.println(Thread.currentThread().getName() + ": Boxes before add -> " + warehouse.getBoxesCount());
                    warehouse.setBoxesCount(warehouse.getBoxesCount() + 1);
                    System.out.println(Thread.currentThread().getName() + ": Added a box -> " + warehouse.getBoxesCount());
                } else {
                    break;
                }
            }
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Producer ended");
    }
}
