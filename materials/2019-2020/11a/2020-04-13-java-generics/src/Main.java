import java.util.ArrayList;
import java.util.List;

public class Main {
    /*public static void main(String[] args) {
        List<Number> list = new ArrayList<>();

        Test<Number> t1 = new Test<>(5);
        Test<Integer> t2 = new Test<>(5);
        //Test<String> t3 = new Test<>("5");

        Test.<Number>fn(5);
        Test.<String>fn("15");
        Test.<Main>fn(new Main());
    }*/

    public static void main(String[] args) {
        //Payload<Number> pay = new Payload<>(15);
        //Package pak = new Package(pay);

        Package pak = new Package();
        pak.deserialize("15", new Helper<Number>() {
            @Override
            public Number help(String data) {
                return Integer.parseInt(data);
            }
        });

        System.out.println(pak.serialize());
    }
}
