#pragma once

/*
#ifndef LIST_HH
#define LIST_HH

...

#endif
*/

class Node {
public:
  int value = 0;
  Node *next = nullptr;
  Node *prev = nullptr;

  Node() {}
  Node(int value) : value(value) {}
};

class List {
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

  List operator+(int value);   // a = b + c
  List& operator+=(int value); // a = (b += c)
  List operator-(int value);   // a = b - c
  List& operator-=(int value); // a = (b -= c)
  int operator[](unsigned int index); // a = b[c]

  void print();
};
/*
list.get(index) list.at(index)
list[index]
*/
