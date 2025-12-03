import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Stream<Integer> myStream = Stream.of(1, 2, 3, 4);

//        myStream.forEach(a -> System.out.println("Before map " + a));
//        myStream.map(a -> a * 2).filter(a -> a > 5);
//        myStream.forEach(a -> System.out.println("Before filter " + a));
//        myStream.filter(a -> a > 5);
//        myStream.forEach(a -> System.out.println("After filter " + a));

//        myStream
//                .map(a -> a * 2)
//                .forEach(a -> System.out.println("Before filter " + a))
//                .filter(a -> a > 5);
        long count = myStream
                .map(a -> a * 2)
                .filter(a -> a > 5)
                .count();
        System.out.println(count);

        int[] myArr = new int[]{1,2,3,4};
        Arrays.stream(myArr)
                .map(a -> a * 2)
                .filter(a -> a > 5)
                .forEach(a -> System.out.println(a));
        Arrays.stream(myArr)
                .map(a -> a * 2)
                .sum();

        List<Integer> myList = new ArrayList<>();
        myList.add(1); myList.add(2); myList.add(3); myList.add(4);

        myList = myList.stream()
                .filter(a -> a > 2)
                .map(a -> a * 2)
                .collect(Collectors.toList());

        Random rand = new Random();
        Stream.generate(() -> rand.nextInt())
                .limit(5)
                .count();

        Stream.iterate(0, (a) -> a + 2)
                .limit(5)
                .count();

//        Stream.iterate(3, (a) -> fib(a))
        Stream.iterate(1, (a) -> a + 1)
                .map(a -> fib(a))
                .limit(10)
                .collect(Collectors.toList())
                .getLast();

        try {
            Files.lines(Path.of("someFIle"))
                    .count();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}