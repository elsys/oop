#ifndef BINARY_TREE_HH
#define BINARY_TREE_HH

class BinaryTree {
    int data = 0;
    BinaryTree *left = nullptr;
    BinaryTree *right = nullptr;
public:
    BinaryTree();

    BinaryTree(int data);

    int getData();

    void add(int data);

    void print();
};

#endif
