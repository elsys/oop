#pragma once

/*
#ifndef LIST_HH
#define LIST_HH

...

#endif
*/
/*
class Node {
public:
  int value = 0;
  Node *next = nullptr;
  Node *prev = nullptr;

  Node() {}
  Node(int value) : value(value) {}
};*/
/*
// Completely static class
class Test {
  Test() {}
public:
  static int attr1;
  static float attr2;
  static void foo();
};
*/

/*
class Iterator {
  Node *curr = nullptr;
  Iterator() {}
  Iterator(Node *curr) : curr(curr) {}
public:
  friend class List;

  Iterator operator++(int); // Iterator++
  Iterator operator--(int); // Iterator--
  // a + (b++ - c )
  int operator*() const; // node->value
  bool operator!=(const Iterator &other) const; // Iterator != Iterator
};
*/
class List {
  // Move Node and Iterator to inner classes for List
  // They're private so only List can access and instantiate them
  class Node {
  public:
    int value = 0;
    Node *next = nullptr;
    Node *prev = nullptr;

    Node() {}
    Node(int value) : value(value) {}
  };

  class Iterator {
    Node *curr = nullptr;
    //Iterator() {}
  public:
    Iterator(Node *curr) : curr(curr) {}
    //friend class List;

    Iterator operator++(int); // Iterator++
    Iterator operator--(int); // Iterator--
    // a + (b++ - c )
    int operator*() const; // node->value
    bool operator!=(const Iterator &other) const; // Iterator != Iterator
  };

  Node *head = nullptr;
  Node *tail_abs = nullptr;
  Node *tail_list = nullptr;
  unsigned int capacity = 0;
  unsigned int size = 0;
public:
  List() {}
  List(unsigned int capacity); // With initial capacity
  List(const List &other); // Copy constructor
  ~List();

  void grow(); // Double the capacity and create enough empty nodes
  void push_back(int value);
  void push_front(int value);
  void pop_back();
  void pop_front();
  // Helper method used by operator- and operator-=. It makes sense to make
  // it public so the user has normal access to it like operator+= and push_back
  void remove_value(int value);

  List operator+(int value) const;   // a = b + c
  List& operator+=(int value); // a = (b += c)
  List operator-(int value) const;   // a = b - c
  List& operator-=(int value); // a = (b -= c)
  int operator[](unsigned int index); // a = b[c]

  Iterator begin();
  Iterator end();

  void print();
};
/*
list.get(index) list.at(index)
list[index]
*/
