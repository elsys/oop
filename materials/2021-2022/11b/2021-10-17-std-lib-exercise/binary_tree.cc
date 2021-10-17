#include <iostream>
#include <queue>

#include "binary_tree.hh"

using namespace std;

BinaryTree::BinaryTree() {}

BinaryTree::BinaryTree(int data) {
    this->data = data;
}

int BinaryTree::getData() {
    return data;
}

void BinaryTree::add(int data) {
    if(data < this->data) { // Smaller go left
        if(this->left != nullptr) {
            this->left->add(data);
        } else {
            this->left = new BinaryTree(data);
        }
    } else { // Larger or equal go right
        if(this->right != nullptr) {
            this->right->add(data);
        } else {
            this->right = new BinaryTree(data);
        }
    }
}

void BinaryTree::print() {
    // Just print all items on new lines
    /*queue<BinaryTree*> items;
    items.push(this);

    while(items.size() > 0) {
        // Take the first item in the queue
        BinaryTree *curr = items.front();
        items.pop();

        if(curr != nullptr) {
            cout << " " << curr->getData() << " " << endl; // Print the item

            // Push the children to the queue
            items.push(curr->left);
            items.push(curr->right);
        } else {
            cout << " - " << endl; // Show NULL items as - for readability
        }
    }*/

    // Print each tree level on a new line
    queue<BinaryTree*> items, swap;
    items.push(this);

    while(items.size() > 0) {
        while(items.size() > 0) {
            // Take the first item in the queue
            BinaryTree *curr = items.front();
            items.pop();

            if(curr != nullptr) {
                cout << " " << curr->getData() << " "; // Print the item

                // Push the children to the queue
                swap.push(curr->left);
                swap.push(curr->right);
            } else {
                cout << " - "; // Show NULL items as - for readability
            }
        }
        cout << endl;
        items.swap(swap);
    }
}
