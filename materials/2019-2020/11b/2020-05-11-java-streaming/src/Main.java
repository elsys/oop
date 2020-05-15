import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);
        numbers.add(50);

        /*List<Integer> result = numbers.stream()
                .skip(2)
                .collect(Collectors.toList());

        for (Integer num : result) {
            System.out.println(num);
        }*/

        /*List<Integer> result = numbers.stream()
                .map((a) -> a * 13)
                .filter((a) -> a > (25  * 13))
                .collect(Collectors.toList());

        for (Integer num : result) {
            System.out.println(num);
        }*/

        /*Optional<Integer> result = numbers.stream()
                .map((a) -> {
                    System.out.println("Map for " + a);
                    return a * 13;
                })
                .filter((a) -> {
                    System.out.println("Filter for " + a);
                    return a > (25);
                })
                .findFirst();
                //.collect(Collectors.toList());

        System.out.println(result);*/
        /*for (Integer num : result) {
            System.out.println(num);
        }*/

        /*Optional<Integer> result = numbers.stream()
                .map((a) -> a * 13)
                .filter((a) -> a > (25  * 13))
                .reduce((a, b) -> a + b);

        System.out.println(result);*/

        /*List<Integer> result = numbers.parallelStream()
                .filter((a) -> {
                    System.out.println("Filter for " + a);
                    return a > (25);
                })
                .map((a) -> {
                    System.out.println("Map for " + a);
                    return a * 13;
                })
                .collect(Collectors.toList());

        for (Integer num : result) {
            System.out.println(num);
        }*/

        Optional<Integer> result = numbers.parallelStream()
                .filter((a) -> {
                    System.out.println("Filter for " + a);
                    return a > (25);
                })
                .map((a) -> {
                    System.out.println("Map for " + a);
                    return a * 13;
                })
                .findFirst();

        System.out.println(result);
    }
}
