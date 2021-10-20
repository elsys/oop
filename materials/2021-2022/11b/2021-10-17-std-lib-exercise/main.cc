#include "binary_tree.hh"

int main() {
    BinaryTree tree = BinaryTree(5);

    tree.add(12);
    tree.add(17);
    tree.add(2);
    tree.add(0);
    tree.add(14);
    tree.add(-2);
    tree.add(-1);

    tree.print();

    return 0;
}
