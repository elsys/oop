import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Animal myAnimal = new Animal("cow", 10);
        Cow myCow = new Cow(10);

        myCow.milk();

        List<Animal> animals = new ArrayList<>();
        animals.add(myCow);

        List<IMilkable> milkables = new ArrayList<>();
        milkables.add(myCow);
        for (IMilkable m : milkables) {
            m.milk();
        }
    }
}
