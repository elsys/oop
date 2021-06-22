import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Float> track = Arrays.asList(10f, 15f, 25f, 20f, 30f);
        List<Car> cars = new LinkedList<>();
        cars.add(new Car("A", 5));
//        cars.add(new Car("B", 5));
//        cars.add(new Car("B", 5));

        Raace race = new Raace(cars, 3, track);

        race.run();
    }
}
