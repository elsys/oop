import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<Integer> nums1 = new LinkedList<>();
        nums1.add(3);
        nums1.add(1);
        nums1.add(2);

        List<Integer> nums2 = nums1.stream()
                .filter(a -> a >= 10)
//                .limit(1)
                .map(a -> a * 5)
                .sorted()
                .toList();
        System.out.println(nums2);

        Stream<Integer> nums3 = nums1.stream();
        Stream<Integer> nums4 = nums3.map(a -> a * 5);
        List<Integer> nums5 = nums4.toList();
//        nums4.toList();
        System.out.println(nums5);

        Stream.generate(() -> new Random().nextInt())
                .skip(5)
                .limit(15)
                .skip(5)
                .sorted()
//                .forEach(a -> System.out.println(a));
                .forEach(System.out::println);

        Stream.iterate(0, a -> a + 5)
                .limit(10)
                .forEach(System.out::println);
        for(int a = 0; a < 10; a++)
            System.out.println(a);

        Stream.of(1, 2, 3, 4, 5)
                .forEach(System.out::println);
        Arrays.stream(new int[]{1, 2, 3, 4, 5})
                .forEach(System.out::println);
        "asdfgh".chars()
                .forEach(System.out::println);

        int a = 5;
        Integer b = 5;
        int c = b;
        Integer d = Integer.valueOf(5);
        int e = Integer.valueOf(5);

//        IntStream.of(1,2,3,4,5)
//                .summaryStatistics()
//                .max()
//                .sum();
        nums1.stream()
                .collect(() -> {

                })
    }
}