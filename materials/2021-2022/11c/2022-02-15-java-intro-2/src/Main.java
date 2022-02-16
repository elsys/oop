import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello WOrld");

        int a = 5;
        Integer b = 5;

        //int[] c;
        //int[] c = new int[7];
        int[] c = {1,2,3,4,5,6,7};
        c[4] = 5;

        int d = 0; // :(
        System.out.println(d);
        System.out.println(c[2]);

        for(int i = 0; i < c.length; i++) {
            System.out.println(c[i]);
        }
        for (int ci : c) {
            System.out.println(ci);
        }

        //int[] e = new int[a];
        //e = new int[a + 5];

        Vector<Integer> e = new Vector<Integer>();
        e.add(5);
        //e.
        for(int i = 0; i < e.size(); i++) {
            System.out.println(e.get(i));
        }
        for (int ei : e) {
            System.out.println(ei);
        }

        Vector<Singer> f = new Vector<>();
        f.add(new Singer("Stefan", 20));
        f.add(new Singer("Petar", 200));

        /*f = {
            new Singer("Stefan", 20)  ,
            new Singer("Petar", 200)
        };*/

        for (Singer singer : f) {
            System.out.println(singer.name + " " + singer.salary);
        }
    }

    class List {
        Node head;
        Node tail;
    }
    class Node {
        int value;
        Node next;

        void add(Node other) {
            next = other;
        }
    }


}
