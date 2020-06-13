public class Truck implements Runnable {
    int cargo = 0;
    int capacity = 20;

    @Override
    public void run() {
        while(true) {
            try {
//                System.out.println(cargo);
//                while(cargo == 0) {
//                    // wait
//                }

                synchronized (this) {
                    this.wait();
                }

                System.out.println("Truck going to the factory");
                Thread.sleep(1000);

                System.out.println("Truck unloading");
                cargo = 0;

                System.out.println("Truck going to the station");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    public synchronized void load(int capacity) {
        cargo = capacity;
        notify();
    }
}
