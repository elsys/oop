import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*List<Integer> strings = new ArrayList<>();
        strings.add(123);
        strings.add
        strings.add(false);*/

        /*List<Number> num = new ArrayList<>();
        num.add((Integer)14);
        num.add((Double)1.123);
        //num.add((Character)'d');

        List<Object> obj = new ArrayList<>();
        obj.add(14);
        obj.add((Double)1.123);
        obj.add((Character)'d');

        obj.get(0).getClass();*/

        BinaryTree<Integer> tree1 = new BinaryTree<>();

        tree1.add(7);
        tree1.add(3);
        tree1.add(5);
        tree1.add(9);
        tree1.add(8);

        System.out.println(tree1);
    }
}
