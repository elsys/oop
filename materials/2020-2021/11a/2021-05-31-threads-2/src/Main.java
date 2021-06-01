public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread warehouse = new Thread(new AmazonWarehouse());
        warehouse.start();

        Thread.sleep(3 * 1000);
        //warehouse.stop();
        warehouse.interrupt();
        //Thread.sleep(1000, 100);
        warehouse.interrupt();
        System.out.println("Program has finished");
    }
}
