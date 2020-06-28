import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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


        ExecutorService ex = Executors.newFixedThreadPool(5);

        ex.execute(new Train(station1, station2));
        ex.execute(new Train(station1, station2));
        ex.execute(new Train(station1, station2));
        ex.execute(new Train(station1, station2));
        ex.execute(new Train(station1, station2));

        ex.execute(new Train(station1, station2));

        try {
            Thread.sleep(6000);
            ex.shutdown();
            System.out.println("Complete!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        ex.execute(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    System.out.println("Henlo");
//                    Thread.sleep(5000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
    }
}
