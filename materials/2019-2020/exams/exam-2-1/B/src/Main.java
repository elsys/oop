import org.elsys.oop.exam1.Point;
import org.elsys.oop.exam1.Simulation;
import org.elsys.oop.exam1.target.Dropoff;
import org.elsys.oop.exam1.target.Resource;
import org.elsys.oop.exam1.unit.Raider;
import org.elsys.oop.exam1.unit.Worker;

public class Main {
    public static void main(String[] args) {
        Simulation sim = new Simulation();
        sim.setDropoff(new Dropoff(new Point(), 0));

        sim.addResource(new Resource(new Point(10, 10), 100));
        sim.addResource(new Resource(new Point(25, 0), 100));
        sim.addResource(new Resource(new Point(-50, -20), 100));

        sim.addWorker(new Worker("Worker1", 10, new Point(), 10, 50));
        sim.addWorker(new Worker("Worker2", 10, new Point(), 10, 50));
        sim.addWorker(new Worker("Worker3", 10, new Point(), 10, 50));

        sim.addRaider(new Raider("Raider1", 25, new Point(50, 50), 100, 20, 2));

        sim.run();
    }
}
