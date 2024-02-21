import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new LinkedList<>();
        try {
            numbers = Files.readAllLines(Path.of("numbers_100.txt"))
                    .stream()
                    .map(Integer::parseInt)
//                    .mapToInt(Integer::parseInt)
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        try {
//            BufferedReader fr = new BufferedReader(
//                new FileReader("numbers_100.txt")
//            );
//            String line;
//            while((line = fr.readLine()) != null) {
//                numbers.add(Integer.getInteger(line));
//            }
//            fr.close();
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }


        System.out.println("Max: " + numbers
                .stream()
                .max(Comparator.comparingInt(a -> a))
        );
        System.out.println("Max: " + numbers
                .stream()
                .sorted((a, b) -> b - a)
                .findFirst()
        );

        System.out.println("5 largest: " + numbers
                .stream()
                .sorted((a, b) -> b - a)
                .limit(5)
                .sorted((a, b) -> a - b)
                .toList()
        );

        System.out.println("5 largest: " + numbers
                .stream()
                .sorted(Comparator.comparingInt(a -> a))
                .skip(numbers.size() - 5)
                .toList()
        );

        System.out.println("sum of digits of min: " + numbers
                .stream()
                .sorted()
                .limit(1)
//                .peek(a -> System.out.println(a))
                .map(a -> a.toString().split(""))
                .flatMap(Arrays::stream)
                .map(Integer::parseInt)
                .reduce(0, Integer::sum)
//                .flatMapToInt(a -> Arrays.stream(a).map(Integer::parseInt))
//                .toList()
        );

        System.out.println(numbers
                .stream()
                .filter(a -> a % 5 == 0)
                .mapToInt(a -> a)
                .sum()
        );

        System.out.println(numbers
                .stream()
                .collect(Collectors.groupingBy(
                    a -> a % 2 == 0 ? "even" : "odd"
                ))
        );
        System.out.println(numbers
                .stream()

//      <U> U reduce(U identity,
//                   BiFunction<U, ? super T, U> accumulator,
//                   BinaryOperator<U> combiner);
                .reduce(
                    new HashMap<String, List<Integer>>(),
                    (map, val) -> {
                        String key = val % 2 == 0 ? "even" : "odd";

                        if(map.)

                        return  map;
                    },
                    (a, b) ->
                 )
        );
    }
}
