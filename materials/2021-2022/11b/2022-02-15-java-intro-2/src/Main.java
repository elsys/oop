import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");

        int a = 5;
        Integer b = 5;

        //int[] c;
        //int[] c = new int[0];
        //int[] c = new int[6];
        int[] c = {1, 2, 3, 4, 5, 6, 7};
        c[5] = 4;

//        for(int i =0; i < c.length; i++) {
//            System.out.println(c[i]);
//        }

//        for(int ci : c) {
//            System.out.println(ci);
//        }

        Vector<Integer> d = new Vector<>();
        d.add(3);
        d.add(5);
        d.add(7);

        for (Integer integer : d) {
            System.out.println(integer);
        }

        Vector<Singer> f = new Vector<>();
        f.add(new Singer("Petar", 2011));

        for (Singer singer : f) {
            System.out.println(singer.name + " " + singer.salary);
        }
    }
}
