import java.util.concurrent.locks.ReentrantLock;

public class Truck implements Runnable {
    int capacity;
    int cargo = 0;

    Object myLock = new ReentrantLock();

    public Truck(int capacity) {
        this.capacity = capacity;
    }

//    synchronized void load(int cargo) {
//        this.cargo = cargo;
//        notify();
//        System.out.println("Truck got loaded with " + cargo);
//    }

    void load(int cargo) {
        synchronized(myLock) {
            this.cargo = cargo;
            myLock.notify();
            System.out.println("Truck got loaded with " + cargo);
        }
    }

    @Override
    public void run() {
        while(true) {
            try {
//                synchronized (this) {
//                    wait();
//                }
                synchronized (myLock) {
                    myLock.wait();
                }

                System.out.println("Truck going to the factory...");
                Thread.sleep(1000);
                cargo = 0;

                System.out.println("Truck coming back...");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }

//            if(cargo != 0) {
//                try {
//                    System.out.println("Truck going to the factory...");
//                    Thread.sleep(1000);
//                    cargo = 0;
//
//                    System.out.println("Truck coming back...");
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            } else {
//                // wait
//            }
        }
    }
}
