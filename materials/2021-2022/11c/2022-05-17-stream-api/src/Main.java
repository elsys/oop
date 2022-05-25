import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    private static class BankAccount {
        public float money;

        public BankAccount(float money) {
            this.money = money;
        }

        public void addMoney() {
            money *= 1.1;
        }
    }

    public static void main(String[] args) {
        /*Stream<Integer> a = Stream.of(1, 2, 3);
        a = a.peek(v -> System.out.println(v));
        List<Integer> nums = a.collect(Collectors.toList())*/
        /*List<Integer> nums = Stream
                .of(4, 1, 3, 5, 2, 6)
                .parallel()
                .filter(v -> v > 2.5)
                .sorted()
                .limit(2)
                .peek(v -> System.out.println("peek1: " + v))
                .map(v -> v * 2)
                .peek(v -> System.out.println("peek2: " + v))
                .collect(Collectors.toList());
        System.out.println(nums);*/

        /*List<Float> moneys = Stream.of(
                new BankAccount(100),
                new BankAccount(200),
                new BankAccount(100)
        )
                .peek(v -> v.addMoney())
                .map(v -> v.money)
                .takeWhile(v -> v < 200)
                .collect(Collectors.toList());
        System.out.println(moneys);*/

        Random rand = new Random();
        IntSummaryStatistics summary = Stream
                .generate(() -> rand.nextInt())
                .peek(v -> System.out.println(v))
                .limit(30)
                //.forEach(v -> System.out.println(v));
               // .max(Comparator.comparingInt(a -> a));
                .mapToInt(v -> v)
//                .average();
                .summaryStatistics();
        System.out.println(summary);
        /*while(true) {
            System.out.println(rand.nextInt());
        }*/

        try {
            //List<Integer> nums = new LinkedList<>();
            List<Integer> nums = Files
                    .lines(Path.of("test.txt"))
                    .peek(line -> System.out.println(line))
                    .map(line -> Integer.parseInt(line))
                    .collect(Collectors.toList());
                    //.forEach(line -> nums.add(Integer.parseInt(line)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
