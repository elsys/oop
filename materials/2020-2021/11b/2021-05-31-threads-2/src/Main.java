public class Main {
    public static void main(String[] args) throws InterruptedException {
        AmazonWarehouse wh = new AmazonWarehouse();
        Thread warehouse = new Thread(wh);
        warehouse.start();
        //Thread.sleep(3 * 1000);

        //warehouse.stop();
        //warehouse.join(1 * 1000);
        //warehouse.interrupt();

        //Thread.sleep(3 * 1000);
        //warehouse.interrupt();

        Thread counter = new Thread(() -> {
            while(true) {
                try {
                    Thread.sleep(1500);
                    System.out.println(
                            "Counter: packages are " + wh.getPackageCount()
                    );
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        counter.start();

        for(int i=0; i<10; i++) {
            Thread seller = new Thread(() -> {
                try {
                    for(int j=0; j< 50; j++) {
                        wh.addPackage(j);
                        Thread.sleep(1 * 1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            seller.start();
        }

        while(wh.getPackageCount() < 15) {
            warehouse.join(1 * 1000);
        }
        warehouse.interrupt();

        warehouse.join(5 * 1000);
        if(warehouse.isAlive()) {
            warehouse.interrupt();
        }

        System.out.println("The program finished");
    }
}
