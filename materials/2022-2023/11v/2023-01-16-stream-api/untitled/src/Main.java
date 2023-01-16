import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        //Stream<Integer> s = (Stream<Integer>) Arrays.stream(arr);

        List<Integer> list = new LinkedList<>();
        //Stream<Integer> s2 = list.stream();

        System.out.println(
            Arrays.stream(arr)
                .filter(a -> a > 2)
                .limit(3)
                .skip(1)
                .map(a -> {
                    System.out.println(a);
                    return a * 5;
                })
                .map(a -> a / 5)
//                .filter(a -> a > 10)
                .sum()
        );

        Random rand = new Random();
        Stream.generate(() -> rand.nextInt())
                .limit(100)
                .sorted()
                .distinct()
//                .forEach(a -> System.out.println(a));
                .collect(Collectors.toList());
//                .map(new IntUnaryOperator() {
//                    @Override
//                    public int applyAsInt(int operand) {
//                        return operand * 5;
//                    }
//                })


    }
}







