#include "binary_search_tree.hh"
#include <iostream>

template <typename T>
BinarySearchTree<T>::Box::Box(T const& element, Box* left, Box* right)
  : element(element), left(left), right(right) {}

template <typename T>
typename BinarySearchTree<T>::Box* BinarySearchTree<T>::copy(
    Box const* box) const {
  if (box == nullptr) {
    return nullptr;
  }

  return new Box(box->element, copy(box->left), copy(box->right));
}

template <typename T>
void BinarySearchTree<T>::erase(Box* box) {
  if (box != nullptr) {
    erase(box->left);
    erase(box->right);
    delete box;
  }
}

template <typename T>
BinarySearchTree<T>::BinarySearchTree(): root(nullptr) {}

template <typename T>
BinarySearchTree<T>::BinarySearchTree(BinarySearchTree const& other)
  : root(copy(other.root)) {}

template <typename T>
BinarySearchTree<T>& BinarySearchTree<T>::operator=(
    BinarySearchTree const& other) {
  if (this == &other) {
    return *this;
  }

  erase(root);
  root = copy(other.root);

  return *this;
}

template <typename T>
BinarySearchTree<T>::~BinarySearchTree() {
  erase(root);
}

template <typename T>
bool BinarySearchTree<T>::is_empty() const {
  return root == nullptr;
}

template <typename T>
void BinarySearchTree<T>::insert(const T& element) {
  insert(element, &root);
}

template <typename T>
void BinarySearchTree<T>::insert(const T& element, Box** pos) {
  if (*pos == nullptr) {
    *pos = new Box(element);
  } else if (element < (*pos)->element) {
    insert(element, &(*pos)->left);
  } else if (element > (*pos)->element) {
    insert(element, &(*pos)->right);
  }
}

template <typename T>
bool BinarySearchTree<T>::search(const T& element) const {
  return search(element, root);
}

template <typename T>
bool BinarySearchTree<T>::search(const T& element, Box const* box) const {
  if (box == nullptr) {
    return false;
  }
  if (element == box->element) {
    return true;
  }
  if (element < box->element) {
    return search(element, box->left);
  }
  return search(element, box->right);
}

template <typename T>
std::vector<T> BinarySearchTree<T>::to_vector() const {
  return to_vector(root);
}

template <typename T>
std::vector<T> BinarySearchTree<T>::to_vector(Box const* box) const {
  if (box == nullptr) {
    return std::vector<T>();
  }

  std::vector<T> left = to_vector(box->left);
  std::vector<T> right = to_vector(box->right);
  left.push_back(box->element);
  left.insert(left.end(), right.begin(), right.end());
  return left;
}

template <typename T>
void BinarySearchTree<T>::print() const {
  print(root);
}

template <typename T>
void BinarySearchTree<T>::print(Box const* box) const {
  if (box != nullptr) {
    print(box->left);
    std::cout << box->element;
    if (box->right != nullptr) {
      std::cout << ", ";
    }
    print(box->right);
  }
}
