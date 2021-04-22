public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> tree1 = new BinaryTree<>(null);

        tree1.add(8);
        tree1.add(9);
        tree1.add(3);
        tree1.add(2);
        tree1.add(5);

        //       8
        //    3     9
        //  2   5  - -
        // - - - -
        System.out.println(tree1);

        new BinaryTree.InnerStaticClass();
        new tree1.InnerClass();
    }
}
