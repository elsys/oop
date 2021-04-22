public class BinaryTree<P extends Comparable<P>> {
    private static class Node <V> {
        private V value;
        private Node<V> left = null;
        private Node<V> right = null;

        public Node(V value) {
            this.value = value;
        }

        public Node(V value, Node<V> left, Node<V> right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "\nNode{" +
                    "value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    "}";
        }
    }

    private Node<P> root = null;

    private static <L> Node<L> createNode(L value) {
        return new Node<L>(value, null, null);
    }

    public void add(P value) {
        if(root == null) {
            root = createNode(value);
            return;
        }

        add(value, root);
    }

    private void add(P value, Node<P> node) {
        if(node == null) throw new IllegalArgumentException("Node cannot be null");

        if(value.compareTo(node.value) > 0) {
            // right
            if(node.right != null) {
                // taken
                add(value, node.right);
            } else {
                // empty
                node.right = createNode(value);
            }
        } else {
            // left
            if(node.left != null) {
                // taken
                add(value, node.left);
            } else {
                // empty
                node.left = createNode(value);
            }
        }
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                root +
                "\n}";
    }
}
