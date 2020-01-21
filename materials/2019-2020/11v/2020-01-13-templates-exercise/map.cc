#include "map.hh"

template <typename K, typename V>
KeyValuePair<K, V>::KeyValuePair(K const& key, V const& value)
  : key(key), value(value) {}

template <typename K, typename V>
bool KeyValuePair<K, V>::operator==(KeyValuePair const& other) const {
  return key == other.key;
}

template <typename K, typename V>
bool KeyValuePair<K, V>::operator<(KeyValuePair const& other) const {
  return key < other.key;
}

template <typename K, typename V>
bool KeyValuePair<K, V>::operator>(KeyValuePair const& other) const {
  return key > other.key;
}

template <typename K, typename V>
std::ostream& operator<<(std::ostream& os, KeyValuePair<K, V> const& pair) {
  return os
    << '('
    << pair.key
    << ", "
    << pair.value
    << ')';
}

template <typename K, typename V>
void Map<K, V>::insert(K const& key, V const& value) {
  insert(KeyValuePair<K, V>(key, value), &this->root);
}

template <typename K, typename V>
void Map<K, V>::insert(
    KeyValuePair<K, V> const& element,
    typename BinarySearchTree<KeyValuePair<K, V>>::Box** pos) {
  if (*pos == nullptr) {
    *pos = new typename BinarySearchTree<KeyValuePair<K, V>>::Box(element);
  } else if (element < (*pos)->element) {
    insert(element, &(*pos)->left);
  } else if (element > (*pos)->element) {
    insert(element, &(*pos)->right);
  } else {
    (*pos)->element = element;
  }
}

template <typename K, typename V>
V const* Map<K, V>::search(K const& key) const {
  search(key, this->root);
}

template <typename K, typename V>
V const* Map<K, V>::search(
    K const& key,
    typename BinarySearchTree<KeyValuePair<K, V>>::Box const* box) const {
  if (box == nullptr) {
    return nullptr;
  }
  if (key == box->element.key) {
    return &box->element.value;
  }
  if (key < box->element.key) {
    return search(key, box->left);
  }
  return search(key, box->right);
}
