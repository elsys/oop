import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Truck truck = new Truck();

        Station station1 = new Station();
        Station station2 = new Station(truck);

        Thread trainThread = new Thread(new Train(station1, station2));
        Thread truckThread = new Thread(truck);

        trainThread.start();
        truckThread.start();

        try {
//            trainThread.join();
//            truckThread.join();
            Thread.sleep(5 * 1000);
            trainThread.interrupt();
            truckThread.interrupt();
            System.out.println("Complete!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        try {
            FileWriter fw = new FileWriter("out.txt");

            fw.write("asdf");

            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            FileReader fr = new FileReader("in.txt");

            fr.read();

            fr.close();

//            FileInputStream fis = new FileInputStream("in.txt");
//
//            fis.
//
//            fis.close();
            Scanner sc = new Scanner("in.txt");

            String line = sc.nextLine();

            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
