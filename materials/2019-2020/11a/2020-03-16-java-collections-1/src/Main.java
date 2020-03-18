import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<Integer>();
        List<Integer> otherNumbers = new LinkedList<Integer>();

        numbers.add(16);
        numbers.add(75);
        numbers.add(34);
        otherNumbers.add(16);
        otherNumbers.add(75);
        otherNumbers.add(34);

        printList(numbers);

        System.out.println(numbers == otherNumbers);
        System.out.println(numbers.equals(otherNumbers));
        System.out.println("===================");

        Virus v1 = new Virus();
        Virus v2 = new Virus();

        v1.name = "Trumpf";
        v2.name = "Trumpf";

        System.out.println(v1 == v1);
        System.out.println(v1 == v2);
        System.out.println(v1.equals(v2));
        System.out.println(v1.equals((Object)v2));
        System.out.println("===================");

        Set<Virus> viruses = new HashSet<Virus>();
        viruses.add(v1);
        viruses.add(v2);

        printList(viruses);
    }

    static void printList(Iterable list) {
       // List l = (List)list;
       //for(int i=0; i<list.size(); i++) {
        //    System.out.println(list.get(i));
       // }
        Iterator it = list.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
