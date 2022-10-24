import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
//        List<Integer> ints = new LinkedList<>();
//        ints = new ArrayList<>();
//        ints = new Stack<>();
//
//        foo(ints);
        Calculator calc = new Calculator();
        calc.addOp(new Add());
        calc.addOp(new Sub());

        System.out.println(calc.run("2 3 4 + +"));
        System.out.println(calc.run("2 3 4 + -"));
        System.out.println(calc.run("3 4 + 2 -"));
    }

//    public static void foo(List<Integer> arg) {
//
//    }
}
