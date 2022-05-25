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
        //List<String> a;
        //a.sort((left, right) -> left.compareTo(right));

        /*List<Integer> nums = Stream
                //.<Double>of(1.0, 2f, 3f, 4f)
                .of(4, 5, 2, 3, 6, 7, 1, 8)
                .filter(v -> v > 2.5)
                .sorted((a, b) -> b - a)
                .limit(2)
                .parallel()
                .peek(v -> System.out.println("peek1 " + v))
                .map(v -> v * 2)
                .peek(v -> System.out.println("peek2 " + v))
                .collect(Collectors.toList());
        System.out.println(nums);*/

        //List<Float> allMoney = Stream
        /*Stream
                .of(
                        new BankAccount(100),
                        new BankAccount(200),
                         new BankAccount(100)
                )
                .takeWhile(v -> v.money < 200)
                .peek(v -> v.addMoney())
                .map(v -> v.money)
//                .map(v -> {
//                    v.addMoney();
//                    return v.money;
//                })
//                .collect(Collectors.toList());
//                .forEach(v -> System.out.println(v));
                .findFirst();*/
//        List<Float> a;
//        a.stream()....;
//        Arrays.stream(new int[]{1, 2, 3}) ...
        Random rand = new Random();
        IntSummaryStatistics summary = Stream
                .generate(() -> rand.nextInt())
                .limit(30)
                //.forEach(v -> System.out.println(v));
                .mapToInt(v -> v)
                //.average();
                .summaryStatistics();
        System.out.println(summary);
        //double a = summary.getAverage();

    }
}





