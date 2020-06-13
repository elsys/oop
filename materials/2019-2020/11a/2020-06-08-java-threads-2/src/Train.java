public class Train implements Runnable {
    Station station1;
    Station station2;
    int load = 0;

    public Train(Station station1, Station station2) {
        this.station1 = station1;
        this.station2 = station2;
    }

    @Override
    public void run() {
        while(true) {
            try {
                System.out.println("Train loading from station 1");
                load += station1.loadTrain();

                System.out.println("Train going to station 2");
                Thread.sleep(2000);

                System.out.println("Train unloading at station 2");
                station2.unloadTrain(load);
                load = 0;

                System.out.println("Train going to station 1");
                Thread.sleep(2000);

                // some very slow logic
                if(Thread.interrupted()) {
                    throw new InterruptedException();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
