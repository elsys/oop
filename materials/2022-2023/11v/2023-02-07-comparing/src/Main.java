import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Dog> dogs = new LinkedList<>();

        dogs.add(new Dog("Sharo", 5, true));
        dogs.add(new Dog("Evlogi", 5, false));
        dogs.add(new Dog("Vulkan", 8, true));
        dogs.add(new Dog("Bekon", 1, false));
        dogs.add(new Dog("Sharo", 4, true));

        System.out.println("Before sort:");
        dogs.forEach((d) -> System.out.println(d));

//        Collections.sort(dogs);
//        System.out.println("After sort:");
//        dogs.forEach((d) -> System.out.println(d));

//        Comparator<Dog> c1 = new Comparator<Dog>() {
//            @Override
//            public int compare(Dog o1, Dog o2) {
//                int nameComparison = o1.name.compareTo(o2.name);
//                if(nameComparison != 0) return nameComparison;
//
//                return Integer.compare(o1.age, o2.age);
//            }
//        };

//        Comparator<Dog> c1 = (o1, o2) -> {
//            int nameComparison = o1.name.compareTo(o2.name);
//            if(nameComparison != 0) return nameComparison;
//
//            return Integer.compare(o1.age, o2.age);
//        };

        System.out.println("After comparator:");
//        dogs.sort(c1);
//        dogs.sort((o1, o2) -> {
////            int nameComparison = o1.name.compareTo(o2.name);
////            if(nameComparison != 0) return nameComparison;
////
////            return Integer.compare(o1.age, o2.age);
////        });
//        dogs.sort(
//                Comparator.comparing(Dog::getName)
//                .thenComparing(Comparator.comparing(Dog::getAge))
//                .reversed()
//        );
//        dogs.forEach((d) -> System.out.println(d));

        System.out.println("After stream:");
        dogs
                .stream()
//                .sorted()
//                .sorted((o1, o2) -> Integer.compare(o1.age, o2.age))
                .sorted(
                        Comparator.comparing(Dog::getAge)
                                .reversed()
                )
                .toList()
                .forEach((d) -> System.out.println(d));
    }
}
