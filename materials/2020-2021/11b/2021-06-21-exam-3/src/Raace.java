import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Raace {
    private List<Car> cars = new LinkedList<>();
    private int targetLaps;
    private List<Float> track;

    public Raace(List<Car> cars, int targetLaps, List<Float> track) {
        this.cars = cars;
        this.targetLaps = targetLaps;
        this.track = track;
    }

    public Raace(int targetLaps) {
        this.targetLaps = targetLaps;
        track = new LinkedList<>();
    }

    public void run() {
        for(int i = 0; i < cars.size(); i++) {
            Car c = cars.get(i);
            c.reset();
            c.setCurrPos(i + 1);
            c.setTargetLaps(targetLaps);

            c.setTrack((j) -> track.get(j));
//            c.setTrack(new Car.ITrackAccess() {
//                @Override
//                public float get(int j) {
//                    return track.get(j);
//                }
//            });
        }

        ExecutorService manager = Executors.newFixedThreadPool(cars.size());
        for(Car c : cars) {
            manager.submit(c);
        }

        for(Car c : cars) {
            c.startRace();
        }

        while(!isRaceFinished()) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            sortCars();
            printCars();
        }

        manager.shutdown();
    }

    private void printCars() {
        for(Car c : cars) {
            System.out.println(c);
        }
    }

    private void sortCars() {
        cars.sort((c1, c2) -> {
            if(c1.getCurrLap() != c2.getCurrLap())
                return c1.getCurrLap() - c2.getCurrLap();

            if(c1.getCurrSegment() != c2.getCurrSegment())
                return c1.getCurrSegment() - c2.getCurrSegment();

            return (int) (c1.getCurrLapTime() - c2.getCurrLapTime());
        });

        for(int i = 0; i < cars.size(); i++) {
            Car c = cars.get(i);
            c.setCurrPos(i + 1);
        }
    }

    private boolean isRaceFinished() {
        return cars.stream().anyMatch((c) -> c.getCurrLap() < targetLaps);
    }
}
