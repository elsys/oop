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
                load += station1.loadTrain();
                System.out.println("Loaded");

                Thread.sleep(500);

                station2.unloadTrain(load);
                load = 0;
                System.out.println("Unlaoded");

                Thread.sleep(500);

                // some very long logic
                if(Thread.interrupted()) {
                    throw new InterruptedException();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }

        while(true) {
            try {
                load += station1.loadTrain();
                System.out.println("Loaded");

                Thread.sleep(500);

                station2.unloadTrain(load);
                load = 0;
                System.out.println("Unlaoded");

                Thread.sleep(500);

                // some very long logic
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
