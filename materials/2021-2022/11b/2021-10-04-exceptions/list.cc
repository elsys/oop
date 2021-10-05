#include <iostream>
#include <exception>
#include <stdlib.h>
#include "list.hh"

using namespace std;

Node::Node() {
  value = 0;
  next = prev = nullptr;
}

Node::Node(int value) {
  this->value = value;
  next = prev = nullptr;
}

void Node::test() {
  cout << "Node test" << endl;
}

void List::push(int value) {
  //Node* new_node = (Node*)malloc(sizeof(Node));
  //new (new_node)(Node);
  //new_node->test();
  //new_node->value = value;
  //new_node->next = new_node->prev = nullptr;
  
  Node* new_node = new Node(value);
  
  //if(head == nullptr) {
  if(size == 0) {
    //tail = head = new_node;
    head = new_node;
  } else {
    tail->next = new_node;
    new_node->prev = tail;
  }
  
  tail = new_node;
  size++;
}

void List::print() {
  Node* curr = head;
  int pos = 0;
  while(curr != nullptr) {
    cout << "[" << pos++ << "]" << curr->value << endl;
    curr = curr->next;
  }
}



int List::get_at(int pos) {
  if(size < pos) {
    //throw 2;
    //throw "pos is too large";
    //throw exception();
    throw my_ex();
  }
  
  Node* tmp = head;
  //int i = 0;
  //while(i++ != pos) {
  while(pos-- > 0) {
    tmp = tmp->next;
  }
  
  return tmp->value;
}



