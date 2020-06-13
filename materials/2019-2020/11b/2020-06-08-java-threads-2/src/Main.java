public class Main {
    public static void main(String[] args) {
        Truck truck = new Truck(15);

        Station station1 = new Station();
        Station station2 = new Station(truck);

        Thread trainThread = new Thread(new Train(station1, station2));
        Thread truckThread = new Thread(truck);

        trainThread.start();
        truckThread.start();

        try {
            /*trainThread.join();
            truckThread.join();*/
            Thread.sleep(5 * 1000);
            trainThread.interrupt();
            truckThread.interrupt();
            System.out.println("Complete!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
