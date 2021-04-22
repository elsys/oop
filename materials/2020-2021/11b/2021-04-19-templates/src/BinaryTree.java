public class BinaryTree <T extends Comparable> {
    private static class Node<T> {
        private T value;
        public Node left;
        public Node right;

        public T getValue() {
            return value;
        }

        public Node(T value) {
            this.value = value;
            left = right = null;
        }

        public Node(T value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public class InnerClass {}
    public static class InnerStaticClass {}

    private Node<T> root;

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(Node<T> root) {
        this.root = root;
    }

    public Node<T> getRoot() {
        return root;
    }

    private static <P> Node<P> createNode(P value) {
        return new Node<P>(value);
    }

    public void add(T value) {
        if(root == null) {
            root = createNode(value);
            return;
        }

        add(value, root);
    }

    private void add(T value, Node curr) {
        if(curr == null) {
            throw new IllegalArgumentException("Node cannot be null");
        }

        if(value.compareTo(curr.value) > 0) {
            if(curr.right != null) {
                add(value, curr.right);
                return;
            } else {
                curr.right = createNode(value);
            }
        } else {
            if(curr.left != null) {
                add(value, curr.left);
                return;
            } else {
                curr.left = createNode(value);
            }
        }
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                root +
                '}';
    }
}
