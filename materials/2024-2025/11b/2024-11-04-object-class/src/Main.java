import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();

        System.out.println(o1);
        System.out.println(o2);
        System.out.println(o1 == o2);
        System.out.println(o1.equals(o2));
        System.out.println(o1.toString());

        Pastry p1 = new Pastry("Prava", false);
        Pastry p2 = new Pastry("Sofiiska", true);
        Pastry p3 = new Pastry("Prava", false);

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p1 == p2);
        System.out.println(p1.equals(p2));
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());

        System.out.println(p1 == p3);
        System.out.println(p1.equals(p3));

        Map<Pastry, Pastry> map1 = new HashMap<>();
        map1.put(p1, p1);
        map1.put(p2, p2);
        map1.put(p3, p3);
        System.out.println(map1);
        System.out.println(map1.keySet());

        Map<Pastry, Pastry> map2 = new TreeMap<>();
        map2.put(p1, p1);
        map2.put(p2, p2);
        map2.put(p3, p3);
        System.out.println(map2);
        System.out.println(map2.keySet());
    }
}