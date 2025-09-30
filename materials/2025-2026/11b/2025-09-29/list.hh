#pragma once
#include <iostream>

template <typename T>
class List {
  // class Node {
  // public:
  //   int value;
  //   Node* next;
  //   Node(int val) : value(val), next(nullptr) {}
  // };

  struct Node {
    T value;
    Node* next;
    Node(T val) : value(val), next(nullptr) {}
  };

  Node* head = nullptr;
public:
  ~List()  {
    // Destructor to free memory
    Node* current = head;
    while (current) {
      Node* nextNode = current->next;
      delete current;
      current = nextNode;
    }
  }

  void push_front(T val) {
    Node* newNode = new Node(val);
    newNode->next = head;
    head = newNode;
  }

  void push_back(T val) {
    if (!head) {
      push_front(val);
      return;
    }
    Node* current = head;
    while (current->next) {
      current = current->next;
    }
    current->next = new Node(val);
  }

  void print() {
    Node* current = head;
    while (current) {
      std::cout << current->value << " ";
      current = current->next;
    }
    std::cout << std::endl;
  }
};

// List::Node* List::head = new List::Node(0);