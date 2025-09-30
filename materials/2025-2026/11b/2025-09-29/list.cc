#include <iostream>

#include "list.hh"

List::~List() {
    // Destructor to free memory
    Node* current = head;
    while (current) {
      Node* nextNode = current->next;
      delete current;
      current = nextNode;
    }
}

void List::push_front(int val) {
    Node* newNode = new Node(val);
    newNode->next = head;
    head = newNode;
  }

void List::push_back(int val) {
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

void List::print() {
  Node* current = head;
  while (current) {
    std::cout << current->value << " ";
    current = current->next;
  }
  std::cout << std::endl;
}