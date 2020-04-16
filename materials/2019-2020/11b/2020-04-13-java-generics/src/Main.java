import java.util.ArrayList;
import java.util.List;

public class Main {
    /*public static void main(String[] args) {
        List<Number> list = new ArrayList<>();

        Test<Number> test = new Test<>(new Integer(1));
        //Test<String> test2 = new Test<>();
        System.out.println(test.get());

        Test.<Number>fn(5);
        Test.<String>fn("ASDF");
        //Test.fn(new Main());
        Test.<Test<Number>>fn(test);
    }*/

    public static void main(String[] args) {
        //Payload<Number> pay = new Payload<>(15);
        //Payload<String> pay = new Payload<>("test test");
        //Package pak = new Package(pay);

        Package pak = new Package();
        pak.deserialize("15", new Builder<Number>() {
            @Override
            public Number build(String data) {
                return Integer.parseInt(data);
            }
        });

        System.out.println(pak.serialize());
    }
}
