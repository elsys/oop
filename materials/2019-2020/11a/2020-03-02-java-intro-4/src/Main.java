import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<ISellable> items = new ArrayList<ISellable>();
        /*items.add(new Apple());
        items.add(new Apple(10));
        items.add(new Apple());
        items.add(new Cabbage());
        items.add(new Cabbage());*/
        //Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner("30");
        Apple ap = new Apple(sc.nextInt());
        items.add(ap);

        Market m = new Market();
        m.sell(items);

        //Product p = (Product)items.get(2);
        //p.print_information();
//        Product p2 = new Product() {
//            @Override
//            void print_information() {
//
//            }
//        };
    }
}
