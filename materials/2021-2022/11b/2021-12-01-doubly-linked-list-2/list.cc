#include <iostream>
#include "list.hh"

using namespace std;

// Point to the next node in the list
List::Iterator List::Iterator::operator++(int) {
  List::Iterator old_it = List::Iterator(*this);

  curr = curr->next;

  return old_it;
}

// Point to the previous node in the list
List::Iterator List::Iterator::operator--(int) {
  List::Iterator old_it = List::Iterator(*this);

  curr = curr->prev;

  return old_it;
}

// Simply return the value of the node being pointed
int List::Iterator::operator*() const {
  return curr->value;
}

// Compare the pointers being pointed (no need to compare values)
bool List::Iterator::operator!=(const List::Iterator &other) const {
  return curr != other.curr->next;
}

List::List(unsigned int capacity) : capacity(capacity) {
  cout << "List(unsigned int capacity) called" << endl;
  // Early return because there's nothing to do for a capacity of 0
  if(capacity == 0) return;

  // Until now the list was completely empty. Create the first node and point head and tail
  head = tail_abs = new Node();
  // All other nodes get appended at the end like a normal linked list
  for(unsigned int i = 1; i < capacity; i++) {
    Node *new_node = new Node();

    new_node->prev = tail_abs;
    tail_abs->next = new_node;

    tail_abs = new_node;
  }
}

// Copy constructor which must copy all data from other. For dynamic memory we
// need to allocate new memory and copy the content. Otherwise destructing other
// will free the shared memory and break the program.
List::List(const List &other) : List(other.capacity) {
  cout << "List(const List &other) called" << endl;
  // Call List(unsigned int capacity) in the initializer list
  // because setting the initial capacity and creating elements is identical
  /*
  capacity = other.capacity;
  if(capacity > 0) {
    head = tail_abs = new Node();
  }
  for(unsigned int i = 1; i < capacity; i++) {
    Node *new_node = new Node();

    new_node->prev = tail_abs;
    tail_abs->next = new_node;

    tail_abs = new_node;
  }
  */

  // Iterate all nodes in other and add their values as new nodes
  Node *curr = other.head;
  for(unsigned int i = 0; i < other.size; i++) {
    push_back(curr->value);
    curr = curr->next;
  }
}
// The destructor needs to clear all allocated dynamic memory
List::~List() {
  cout << "~List() called" << endl;

  if(capacity == 0) return;

  // Iterate all nodes and delete them
  Node *curr = head;
  while(curr != NULL) {
    Node *tmp = curr;
    curr = curr->next;

    // Memory was allocated with new so we free it with delete
    delete tmp;
  }

  // Resetting other values is nice, but not required unless you want
  // to be absolutely certain no sensitive data remains in memory
  capacity = 0;
  size = 0;
}

void List::grow() {
  cout << "grow() called" << endl;

  // Special case - current capacity is 0 and all pointers point to NULL
  if(capacity == 0) {
    capacity = 1;
    // Head and tail both point to the first node that gets added
    head = tail_abs = new Node();
    tail_list = nullptr; // We don't need this line because we already set the default value to NULL
    return;
  }

  // The list already has nodes and tail_abs points to the last one.
  // Start adding new nodes at the end until we double their count.
  for(unsigned int i = 0; i < capacity; i++) {
    tail_abs->next = new Node();     // tail->next = new_node
    tail_abs->next->prev = tail_abs; // new_node->prev = tail

    tail_abs = tail_abs->next;       // tail = new_node
  }
  capacity *= 2;
}

void List::push_back(int value) {
  cout << "push_back(int value) called" << endl;

  // Ensure there is at least 1 free node to use
  if(size == capacity) grow();

  if(size == 0) {
    // When we add the first value head and tail point to the same node just like a regular list.
    tail_list = head;
  } else {
    // Point the tail for the used list to the next node
    tail_list = tail_list->next;
  }

  tail_list->value = value;
  size++;
}

void List::push_front(int value) {
  cout << "push_front(int value) called" << endl;

  // If the list is empty push_back and push_front would be identical and we can avoid code repetition
  if(size == 0) {
    push_back(value);
    return;
  }

  if(size == capacity) grow();

  // Take the very last node in the list (we can be certain it is empty) and move it to the front.
  // That way the old tail becomes the new head and the node before the old tail becomes the new tail.
  // A summary of the pointer reassinments is:
  // new_head = old_tail
  // new_tail->next = NULL
  // old_head->prev = new_head
  // new_head->prev = NULL
  // new_head->next = old_head
  Node *new_node = tail_abs;
  tail_abs = tail_abs->prev;
  tail_abs->next = nullptr;

  new_node->prev = nullptr;
  new_node->next = head;

  head->prev = new_node;
  head = new_node;

  head->value = value;
  size++;
}

void List::pop_back() {
  cout << "pop_back() called" << endl;

  if(size == 0) throw range_error("Index out of bounds");

  // Reset the last used node
  tail_list->value = 0;
  // Move the tail pointer to the previous node.
  // If size is 1 then tail_list == head and tail_list->prev == NULL which brings us back to the initial state
  tail_list = tail_list->prev;

  size--;
}

void List::pop_front() {
  cout << "pop_front() called" << endl;

  if(size == 0) throw range_error("Index out of bounds");

  // Clearing a node by returning it to the end of the list mirrors push_front
  // because it's essentially the same operation.
  Node *old_node = head;
  head = head->next;
  head->prev = nullptr;

  old_node->prev = tail_abs;
  old_node->next = nullptr;

  tail_abs->next = old_node;
  tail_abs = old_node;

  old_node->value = 0;
  size--;
}

// Find and remove the value from the segment with used nodes
void List::remove_value(int value) {
  cout << "remove_value(int value) called" << endl;

  // If we want to throw more exceptions just replace these early returns with appropriate throws
  if(size == 0) return;

  // Find either the value to remove or the end of the used segment
  Node *curr = head;
  for(unsigned int i = 0; i < size && curr->value != value; i++, curr = curr->next);

  // If the loop finished and we don't have the value then it isn't in the list
  if(curr->value != value) return;

  // Removing the head is identical to pop_front
  if(curr == head) {
    pop_front();
    return;
  }

  // Removing the tail is identical to pop_back
  if(curr == tail_list) {
    pop_back();
    return;
  }

  // Remove a node that is somewhere between head and tail_list. Reset the value and move the free segment
  // Helper vars for the nodes around the one being moved
  Node *prev = curr->prev;
  Node *next = curr->next;

  // Reset the value and move the node to the end. It becomes the new tail, same logic as pop_front
  curr->value = 0;
  curr->next = nullptr;
  curr->prev = tail_abs;

  tail_abs->next = curr;
  tail_abs = curr;

  // Connect the nodes that were around the one being moved to fill the gap
  prev->next = next;
  next->prev = prev;

  size--;
}

// list1 = list2 + i will create a new list with the content of list2, add i and assign it to list1
// a = b + c
List List::operator+(int value) const {
  cout << "operator+(int value) called" << endl;

  // Create a new instance with the same content of the current one by calling the copy constructor
  List new_list = List(*this);

  // Push the new value and return the copy
  new_list.push_back(value);
  return new_list;
}

// list += i will add i to the same instance
// a = a + c
List& List::operator+=(int value) {
  cout << "operator+=(int value) called" << endl;

  // Just push and return
  push_back(value);
  return *this;
}

// Create a new list and remove the provided value from it
List List::operator-(int value) const {
  cout << "operator-(int value) called" << endl;

  // Again call the copy constructor so that we work on a completely independent instance
  List new_list = List(*this);

  new_list.remove_value(value);

  return new_list;
}

// Same as operator- but modifies the current instance
List& List::operator-=(int value) {
  cout << "operator-=(int value) called" << endl;

  // ¯\_(ツ)_/¯
  remove_value(value);
  return *this;
}

// list[i] will return the value of the node at position i. Intended to work just item access in arrays
int List::operator[](unsigned int index) {
  cout << "operator[](unsigned int index) called" << endl;

  if(index > size) throw range_error("Index out of bounds");

  Node *curr = head;
  for(unsigned int i = 0; i < index; i++, curr = curr->next);

  return curr->value;
}

List::Iterator List::begin() {
  List::Iterator it(head);

  return it;
}

List::Iterator List::end() {
  List::Iterator it(tail_list);

  return it;
}

void List::print() {
  cout << size << "(" << capacity << ")" << endl;
  Node *curr = head;
  for(unsigned int i = 0; i < size; i++) {
    cout << curr->value << endl;
    curr = curr->next;
  }
}
