#ifndef LIST_HH
#define LIST_HH

class Node {
public:
  int value;
  Node* next;
  Node* prev;
  
  Node();
  Node(int value);
  
  void test();
};

class List {
public:
  Node* head = nullptr;
  Node* tail = nullptr;
  int size = 0;
  
  //List() {}
  
  void push(int value);
  void print();
};

#endif
