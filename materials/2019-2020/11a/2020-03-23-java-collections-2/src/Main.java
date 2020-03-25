import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Virus> viruses1 = new ArrayList<>();
        List<Virus> viruses2 = new LinkedList<>();

        Set<Virus> viruses3 = new HashSet<>();
        Map<String, Virus> viruses4 = new HashMap<>();

        for(int i=0; i<10000; i++) {
            //viruses3.add(new Virus("Virus", "TotallyNotChina", 10, false));
            viruses4.put("Virus", new Virus("Virus", "TotallyNotChina", 10, false));
        }

        print(viruses4.entrySet());
    }

    static void print(Iterable coll) {
        Iterator it  = coll.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
