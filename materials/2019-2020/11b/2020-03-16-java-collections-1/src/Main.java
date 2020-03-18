import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new LinkedList<Integer>();
        ArrayList<Integer> otherNumbers = new ArrayList<Integer>();

        numbers.add(10);
        numbers.add(20);
        numbers.add(30);

        otherNumbers.add(10);
        otherNumbers.add(20);
        otherNumbers.add(30);

        printList(otherNumbers);

        System.out.println(numbers == otherNumbers);
        System.out.println(numbers.equals(otherNumbers));
        //System.out.print(numbers. otherNumbers);

        Kalata k1 = new Kalata();
        Kalata k2 = new Kalata();
        //k2.hasPants = true;

        System.out.println("==============");
        System.out.println(k1 == k1);
        System.out.println(k1 == k2);
        System.out.println(k1.equals(k2));

        Set<Kalata> kalas = new HashSet<Kalata>();
        kalas.add(k1);
        kalas.add(k2);

        printList(kalas);
    }

    static void printList(Iterable list) {
        //for(int i=0; i<list.size(); i++) {
        Iterator iter = list.iterator();
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }
       // }
    }
}
