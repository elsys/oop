import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Animal a = new Animal("frog", 10);
        Cow c = new Cow(10);

        List<Animal> myFarm = new ArrayList<>();
        myFarm.add(c);

        List<IMilkable> milkables = new ArrayList<>();
        milkables.add(new Cow(5));
        milkables.add(new Platipus(5));

        c.milk();
    }
}
