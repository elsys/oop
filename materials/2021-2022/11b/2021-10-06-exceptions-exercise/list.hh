#ifndef LIST_HH
#define LIST_HH

#include <exception>
using namespace std;

class Node {
public:
  int value;
  Node* next;
  Node* prev;
  
  Node();
  Node(int value);
  
  void test();
};

class my_ex : exception {
public:
  const char* what() {
    return "my_ex example";
  }
};

class List {
public:
  Node* head = nullptr;
  Node* tail = nullptr;
  int size = 0;
  
  //List() {}
  
  void push(int value);
  void print();
  int get_at(int pos);
};

#endif
