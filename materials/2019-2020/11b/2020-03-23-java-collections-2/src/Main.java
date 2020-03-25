import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Temple> temples1 = new ArrayList<>();
        List<Temple> temples2 = new LinkedList<>();
        Set<Temple> temples3 = new HashSet<>();
        Map<Integer, Temple> temples4 = new HashMap<>();
        Map<Integer, Temple> temples5 = new TreeMap<>();

        for(int i=0; i < 10000000; i++) {
            //temples3.add(new Temple("Temple", "Black Sabbath", 10, false));
            temples5.put(i, new Temple("Temple", "Black Sabbath", 10, false));
        }

        print(temples5.entrySet());
    }

    static void print(Iterable coll) {
        Iterator it = coll.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
