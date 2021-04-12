import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Shoe> shoes = new ArrayList<>();

        shoes.add(new Shoe(35, "Nike", "red"));
        shoes.add(new Shoe(35, "Nike", "red"));
        shoes.add(new Shoe(47, "Puma", "black"));

//        System.out.println(shoes);
        System.out.println("ArrayList:");
        for(Shoe s : shoes) {
            System.out.println(s);
        }

//        Set<Shoe> shoes2 = new TreeSet<>();
//        Set<Shoe> shoes2 = new HashSet<>();
        Set<Shoe> shoes2 = new LinkedHashSet<>();

        shoes2.add(new Shoe(35, "Nike", "red"));
        shoes2.add(new Shoe(35, "Nike", "red"));
        shoes2.add(new Shoe(47, "Puma", "black"));

        System.out.println("Set:");
        for(Shoe s : shoes2) {
            System.out.println(s);
        }

        Map<Shoe, Shoe> shoes3 = new HashMap();

        Shoe s1 = new Shoe(35, "Nike", "red");
        shoes3.put(s1, s1);
        Shoe s2 = new Shoe(35, "Nike", "red");
        shoes3.put(s2, s2);
        Shoe s3 = new Shoe(47, "Puma", "black");
        shoes3.put(s3, s3);

        System.out.println("Map:");
        for(Map.Entry<Shoe, Shoe> s : shoes3.entrySet()) {
            System.out.println(s.getValue());
        }
    }
}
