#include<stdio.h>
#include<stdlib.h>
#include <iostream>
using namespace std;

class ListPushException : exception {
public:
  const char* what() {
    return "ListPushException";
  }
};

class ListPopException : exception {
public:
  const char* what() {
    return "ListPopException";
  }
};

class ListValueException : exception {
public:
  const char* what() {
    return "ListValueException";
  }
};

struct node_int_t {
  int value;
  struct node_int_t *next;
};

class List {
  struct node_int_t *head;
  int max_count;
  int max_value;
  int count;
public:
  List() {
    head = NULL;
    max_count = 10;
    max_value = 1000;
    count = 0;
  }

  List(int m_count, int m_value) {
    head = NULL;
    max_count = m_count;
    max_value = m_value;
    count = 0;
  }

  int is_empty() {
    return count <= 0;
  }

  void push(int value) {
    if(value >= max_value) { throw ListValueException(); }
    if(count >= max_count) { throw ListPushException(); }

    count++;
    struct node_int_t *new_node = (struct node_int_t*)malloc(sizeof(struct node_int_t));
    new_node->value = value;
    new_node->next = NULL;
    if (count == 1) {
      head = new_node;
      return;
    }
    struct node_int_t *current_node = head;
    while (current_node->next) {
      current_node = current_node->next;
    }
    current_node->next = new_node;
  }

  int pop() {
    if(is_empty()) { throw ListPopException(); }

    count--;
    struct node_int_t *current_node = head;
    struct node_int_t *prev_node = NULL;
    while (current_node->next) {
      prev_node = current_node;
      current_node = current_node->next;
    }
    if (prev_node) {
      prev_node->next = NULL;
    } else {
      head = NULL;
    }
    return current_node->value;
  }
};


int main() {
  List l1(15, 100); // max_count == 15, max_value == 100
  List l2; // max_count == 10, max_value == 1000
  cout << "List is empty: " << l1.is_empty() << endl;

  try {
    for (int i = 0; ; i++) {
      l1.push(i);
      cout << "Pushed item: " << i << endl;
    }
  } catch (ListValueException ex) {
    cout << "Caught exception: " << ex.what() << endl;
  } catch (ListPushException ex) {
    cout << "Caught exception: " << ex.what() << endl;
  } catch (exception ex) {
    cout << "Caught another exception" << endl;
  }

  try {
    while (1) {
      int value = l1.pop();
      cout << "Popped item: " << value << endl;
    }
  } catch (ListPopException ex) {
    cout << "Caught exception: " << ex.what() << endl;
  } catch (exception ex) {
    cout << "Caught another exception" << endl;
  }

  cout << "List is empty: " << l1.is_empty() << endl;

  return 0;
}
