#include "binary_search_tree.hh"
#include "map.hh"
#include <iostream>

int main() {
  BinarySearchTree<int> bst;
  bst.insert(1);
  bst.insert(42);
  bst.insert(0);
  bst.insert(2);
  bst.insert(1);
  bst.insert(123);

  std::cout << bst.search(42) << '\n';
  std::cout << bst.search(21) << '\n';

  Map<int, std::string> map;
  map.insert(1, "one");
  map.insert(42, "forty two");
  map.insert(0, "zero");
  map.insert(2, "two");
  map.insert(1, "one");
  map.insert(123, "one hundred and twenty three");

  std::string const* number = map.search(42);
  if (number != nullptr) {
    std::cout << *number << '\n';
  } else {
    std:: cout << "Key 42 not found\n";
  }

  number = map.search(3);
  if (number != nullptr) {
    std::cout << *number << '\n';
  } else {
    std:: cout << "Key 3 not found\n";
  }

  return 0;
}
