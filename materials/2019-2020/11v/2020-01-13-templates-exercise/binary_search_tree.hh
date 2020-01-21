#ifndef BINARY_SEARCH_TREE_HH
#define BINARY_SEARCH_TREE_HH

#include <vector>

template <typename T>
class BinarySearchTree {
protected:
  class Box {
  public:
    T element;
    Box* left;
    Box* right;

    Box(T const& element, Box* left = nullptr, Box* right = nullptr);
  };

  Box* root;

private:
  Box* copy(Box const* box) const;

  void erase(Box* box);

  void insert(const T& element, Box** pos);

  bool search(const T& element, Box const* box) const;

  std::vector<T> to_vector(Box const* box) const;

  void print(Box const* box) const;

public:
  BinarySearchTree();

  BinarySearchTree(BinarySearchTree const& other);

  BinarySearchTree& operator=(BinarySearchTree const& other);

  ~BinarySearchTree();

  bool is_empty() const;

  void insert(const T& element);

  bool search(const T& element) const;

  std::vector<T> to_vector() const;

  void print() const;
};

#endif
