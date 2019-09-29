#include<stdio.h>
#include<stdlib.h>
#include <iostream>
using namespace std;

struct node_int_t {
  int value;
  struct node_int_t *next;
};

/*struct list_int_t {
  struct node_int_t *head;
};*/

class List {
  struct node_int_t *head;
public:
  List() {
    head = NULL;
  }

  int is_empty() {
    return head == NULL;
  }

  void push(int value) {
    struct node_int_t *new_node = (struct node_int_t*)malloc(sizeof(struct node_int_t));
    new_node->value = value;
    new_node->next = NULL;
    if (is_empty()) {
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
    if (is_empty()) { return -1; }
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
  /*void init() {
    head = NULL;
  }*/
};
/*
struct list_int_t *init_int() {
  struct list_int_t *list = malloc(sizeof(struct list_int_t));
  list->head = NULL;
  return list;
}*/
/*
int is_empty_int(struct list_int_t *list) {
  return list->head == NULL;
}*/
/*
void push_int(struct list_int_t *list, int value) {
  struct node_int_t *new_node = malloc(sizeof(struct node_int_t));
  new_node->value = value;
  new_node->next = NULL;
  if (is_empty_int(list)) {
    list->head = new_node;
    return;
  }
  struct node_int_t *current_node = list->head;
  while (current_node->next) {
    current_node = current_node->next;
  }
  current_node->next = new_node;
}*/

int main() {
  List l1;
  //List* l2 = new List();
  //List l3 = List();
  //l1.init();
  //printf("%d\n", l1.is_empty());
  cout << l1.is_empty() << endl;

  for (int i = 0; i < 10; i++) {
    //push_int(list, i);
    l1.push(i);
  }

  while (!l1.is_empty()) {
    int value = l1.pop();
    cout <<  value << endl;
  }

  cout << l1.is_empty() << endl;

  return 0;
}
