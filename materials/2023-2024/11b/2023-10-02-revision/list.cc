#include <iostream>
#include "list.hh"
#include "string.h"

using namespace std;

List::Node::Node(int value) {
    prev = next = nullptr;
    this->value = value;
}

List::Node::Node(Node* prev, Node* next, int value) {
    this->prev = prev;
    this->next = next;
    this->value = value;
}

List::List() {
    head = tail = nullptr;
}

List::~List() {
    clear();
}

void List::push(int value) {

}

int List::pop() {

    return 0;
}

int List::size() {
    return 0;
}

void List::clear() {
}
