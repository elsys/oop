#include <stdlib.h>
#include <math.h>
#include <iostream>

using namespace std;

template <class T>
class ICollection {
public:
  virtual void push(T val) = 0;
  virtual T pop() = 0;
  virtual int is_empty() = 0;
};


template<class T>
class List : public ICollection<T> {
  template<class K>
  class Node {
  public:
    K val;
    Node<K>* next;

    Node(K v) : val(v), next(NULL) {}
  };

  Node<T>* head;
  Node<T>* tail;
public:
  List() : head(NULL), tail(NULL) { }

  void push(T v) {
    Node<T>* newNode = new Node<T>(v);

    if(head == NULL) {
      head = newNode;
    } else {
      tail -> next = newNode;
    }
    tail = newNode;
  }

  T pop() {
    if(head == NULL) {
      return 0;
    }

    T val = head -> val;
    head = head -> next;

    return val;
  }

  int is_empty() {
    return head == NULL;
  }
};

template<class T>
class Vector : public ICollection<T> {
  int count;
  int capacity;
  T* items;

  void resize(int newSize) {
    items = (T*)realloc(items, sizeof(T) * newSize);
    capacity = newSize;
  }
public:
  Vector() : count(0), capacity(0), items(NULL) { }

  Vector(int c) : count(0), capacity(c) {
    items = (T*)malloc(sizeof(T) * capacity);
  }

  void push(T v) {
    if(count >= capacity) resize(max(capacity, 1) * 2);
    items[count++] = v;
  }

  T pop() {
    T val = items[--count];
    if(count <= capacity / 2) resize(capacity / 2);
    return val;
  }

  int is_empty() {
    return count <= 0;
  }
};

template<class T>
void populate_collection(ICollection<T>* c, T b) {
  for(int i=0; i<3; i++) {
    c -> push(b);
  }
}

template<class T>
void print_collection(ICollection<T>* c) {
  while(!c -> is_empty()) {
    T val = c -> pop();
    cout << val << endl;
  }
}

int main() {
  List<int> l1 = List<int>();
  populate_collection<int>(&l1, 1);
  print_collection<int>(&l1);

  List<float> l2 = List<float>();
  populate_collection<float>(&l2, 1.5);
  print_collection<float>(&l2);

  List<double> l3 = List<double>();
  populate_collection<double>(&l3, (double)2);
  print_collection<double>(&l3);

  List<char*> l4 = List<char*>();
  populate_collection<char*>(&l4, "asdf");
  print_collection<char*>(&l4);

  Vector<int> v1 = Vector<int>();
  populate_collection<int>(&v1, 1);
  print_collection<int>(&v1);

  return 0;
}
