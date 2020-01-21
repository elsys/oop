#ifndef MAP_HH
#define MAP_HH

#include "binary_search_tree.hh"
#include <iostream>

template <typename K, typename V>
class KeyValuePair {
public:
  K key;
  V value;

  KeyValuePair(K const& key, V const& value);

  bool operator==(KeyValuePair const& other) const;

  bool operator<(KeyValuePair const& other) const;

  bool operator>(KeyValuePair const& other) const;
};

template <typename K, typename V>
std::ostream& operator<<(std::ostream& os, KeyValuePair<K, V> const& pair);

template <typename K, typename V>
class Map : public BinarySearchTree<KeyValuePair<K, V>> {
  void insert(
      KeyValuePair<K, V> const& element,
      typename BinarySearchTree<KeyValuePair<K, V>>::Box** pos);

  V const* search(
      K const& key,
      typename BinarySearchTree<KeyValuePair<K, V>>::Box const* box) const;

public:
  void insert(K const& key, V const& value);

  V const* search(K const& key) const;
};

#endif
