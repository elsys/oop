public class BST {
    public static class DuplicateValueException extends Exception {
        public final Object duplicateValue;

        public DuplicateValueException(Object duplicateValue) {
            this.duplicateValue = duplicateValue;
        }
    }

    private static class TreeNode {
        Object value;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(Object value) {
            this.value = value;
        }

        public void add(Object value) throws DuplicateValueException {
            if(this.value.equals(value)) {
                throw new DuplicateValueException(value);
            }

            if(value.hashCode() > this.value.hashCode()) {
                if(this.right == null) {
                    this.right = new TreeNode(value);
                    return;
                }
                this.right.add(value);
            } else {
                if(this.left == null) {
                    this.left = new TreeNode(value);
                    return;
                }
                this.left.add(value);
            }
        }
    }

    private TreeNode root = null;

    public void add(Object value) throws DuplicateValueException {
        if(root == null) {
            root = new TreeNode(value);
            return;
        }

//        TreeNode curr = root;
//        while(curr != null) {
//            if (value > curr.value) {
//                // right
//                if (curr.right == null) {
//                    curr.right = new TreeNode(value);
//                    return;
//                }
//                curr = curr.right;
//            } else if (value < curr.value) {
//                // left
//                if (curr.left == null) {
//                    curr.left = new TreeNode(value);
//                    return;
//                }
//                curr = curr.left;
//            } else {
//                // duplicate erro
//            }
//        }

        root.add(value);
    }
}
