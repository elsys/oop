import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> foo = new LinkedList<>();

        foo.add(13);
//        foo.remove(13);

        bar(foo);
        bar(new ArrayList<>());
        bar(new Vector<>());
        bar(new ArrayDeque<>());
        bar(new HashSet<>());
//        bar(new HashMap<>());

        Map<Main, Integer> baz = new HashMap<>();
//        baz.put("myKey", 123);
//        baz.remove("myKey");

        baz = new TreeMap<>();
//        baz.put(new Main(), 123);
//        baz.remove("myKey");

        System.out.println(baz);
//        System.out.println(Math.max(1, 2));

        System.out.println(foo.hashCode());
        System.out.println(baz.hashCode());
        System.out.println(new TreeMap<>().hashCode());
    }

    public static void bar(Collection<Integer> foo) {
        System.out.println(foo);
    }
}
