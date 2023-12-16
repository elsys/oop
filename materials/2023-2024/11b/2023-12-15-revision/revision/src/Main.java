import java.util.Comparator;
import java.util.TreeSet;

public class Main {
    static class Foo implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return 0;
        }

        public int compare(String o1, Integer o2) {
            return 0;
        }
    }

    static class Bar implements Comparable<Bar> {
        @Override
        public int compareTo(Bar o) {
            return 0;
        }
    }

    public static void main(String[] args) {
        Comparator<Integer> c;
        c = new Comparator<Integer>() {
//            int a = 123;
            @Override
            public int compare(Integer o1, Integer o2) {
//                return this.a;
                return 0;
            }
        };
        c = (o1, o2) -> {
            int a = 123;
            return a;
        };

//        c(123, 456);
        c.compare(12, 45);
        foo(c);

        Foo f = new Foo();
        f.compare(123,456);
        f.compare("123", 5567);

        Bar b1 = new Bar();
        Bar b2 = new Bar();

        b1.compareTo(b2);

        TreeSet ts = new TreeSet();
        ts.add(b1);
    }

    public static void foo(Comparator<Integer> c) {
        System.out.println(c.compare(123, 456));
//        System.out.println(c.compare("123", "456"));
    }
}

