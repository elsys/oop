import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
//        List<Integer> nums = Arrays.asList(10, 5, 17, 33, 45);
//        List<Integer> squares = nums.stream()
//                .map((n) -> n * n)
//                .collect(Collectors.toList());
//        List<Integer> squares2 = nums.parallelStream()
//                .map((n) -> n * n)
//                .collect(Collectors.toList());


        List<Integer> nums = new ParallelList<>();
        nums.add(10);
        nums.add(5);
        nums.add(17);
        nums.add(33);
        nums.add(45);

        nums.forEach((n) -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(n * n);
        });
    }
}
