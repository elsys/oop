import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Main {
    public static Random rand = new Random();
    public static class Foo {
        public int val = rand.nextInt() % 5000;

        @Override
        public String toString() {
            return "Foo{" +
                    "val=" + val +
                    '}';
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 9, 3};
        Arrays.sort(arr);

        String[] arr2 = {"zxc", "asd", "qwe"};
        Arrays.sort(arr2);

        Foo[] arr3 = {new Foo(), new Foo(), new Foo(), new Foo()};

//        System.out.println(arr3);
        for (Foo foo : arr3) {
            System.out.println(foo);
        }
        System.out.println("\n");
//        Arrays.sort(arr3);
//        Arrays.sort(arr3, (o1, o2) -> o1.val - o2.val);
        Arrays.sort(arr3, Comparator.comparingInt(o -> o.val));
//        System.out.println(arr3);
        for (Foo foo : arr3) {
            System.out.println(foo);
        }

        List<Foo> arr4 = Arrays.asList(arr3);
        arr4.forEach(foo -> {
            System.out.println(foo);
            foo.val++;
        });
    }
}
