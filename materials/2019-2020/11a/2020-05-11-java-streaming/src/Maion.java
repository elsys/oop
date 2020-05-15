import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Maion {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);
        numbers.add(50);

        /*List<Integer> result = new ArrayList<>();
        for (int i=numbers.size() - 3; i<numbers.size(); i++) {
            result.add(numbers.get(i));
        }

        for(int i=0; i<numbers.size(); i++) {
            if(i<3) {
                continue;
            }
            ...
        }

        for (Integer number : result) {
            System.out.println(number);
        }*/

//        List<Integer> result = numbers.stream()
//                .skip(2)
//                .collect(Collectors.toList());
//
//        for (Integer number : result) {
//            System.out.println(number);
//        }

//        List<Integer> result = numbers.stream()
//                .map((a) -> {
//                    System.out.println("Map for " + a);
//                    return a * 17;
//                })
//                .filter((a) -> {
//                    System.out.println("Filter for " + a);
//                    return a > 500;
//                })
//                .findFirst();
//                .collect(Collectors.toList());

//        for (Integer number : result) {
//            System.out.println(number);
//        }

//        Object[] result = numbers.stream()
//                .filter((a) -> {
//                    System.out.println("Filter for " + a);
//                    return a > 25;
//                })
//                .map((a) -> {
//                    System.out.println("Map for " + a);
//                    return a * 17;
//                })
//                .toArray();
//
//        System.out.println(result);

        /*String result = numbers.stream()
                .filter((a) -> a > 25)
                .map((a) -> a * 17)
                .map(Object::toString)
                .collect(Collectors.joining(", ", "[", "]"));

        System.out.println(result);*/

//        String result = numbers.parallelStream()
//                .map((a) -> {
//                    System.out.println("Map for " + a);
//                    return a * 17;
//                })
//                .filter((a) -> {
//                    System.out.println("Filter for " + a);
//                    return a > 500;
//                })
//                .map((a) -> {
//                    System.out.println("toString for " + a);
//                    return a.toString();
//                })
//                .collect(Collectors.joining(", ", "[", "]"));
//
//        System.out.println(result);

        Optional<String> result2 = numbers.parallelStream()
                .map((a) -> {
                    System.out.println("Map for " + a);
                    return a * 17;
                })
                .filter((a) -> {
                    System.out.println("Filter for " + a);
                    return a > 500;
                })
                .map((a) -> {
                    System.out.println("toString for " + a);
                    return a.toString();
                })
                .findFirst();

        System.out.println(result2);
    }
}
