import java.util.ArrayList;
import java.util.Map;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[] {2, 4, 5, 2, 3, 1};

//        Map<Integer, Vector> res = NumberProcessor
//                .fromArray(arr)
//                .map(new SingleArgWithResult() {
//                    @Override
//                    public int process(int arg) {
//                        return arg * 2;
//                    }
//                })
//                .map(new SingleArgWithResult() {
//                    @Override
//                    public int process(int arg) {
//                        return arg + 2;
//                    }
//                })
//                .filter(new SingleArgWithResult() {
//                    @Override
//                    public int process(int arg) {
//                        return arg % 3 == 0 ? 1 : 0;
//                    }
//                })
//                .groupBy(new SingleArgWithResult() {
//                    @Override
//                    public int process(int arg) {
//                        return arg % 5;
//                    }
//                });

        Map<Integer, Vector> res = NumberProcessor
                .fromArray(arr)
                .map(arg -> (int) (arg * Math.pow(2, 3)))
                .map(arg -> arg + 2)
                .filter(arg -> arg % 3 == 0 ? 1 : 0)
                .map(arg -> {
                    int c = arg;
                    return c * 5;
                })
                .groupBy(arg -> arg % 5);

        System.out.println(res);

        SingleArgWithResult foo = (arg) -> arg * 4;
        System.out.println(foo.process(123));
    }
}
