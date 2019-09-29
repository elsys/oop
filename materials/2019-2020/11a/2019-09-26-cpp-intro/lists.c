#include<stdio.h>
#include<stdlib.h>

struct node_int_t {
  int value;
  struct node_int_t *next;
};

struct list_int_t {
  struct node_int_t *head;
};

struct node_float_t {
  float value;
  struct node_int_t *next;
};

struct list_float_t {
  struct node_float_t *head;
};

struct list_int_t *init_int();
int is_empty_int(struct list_int_t *list);
void push_int(struct list_int_t *list, int value);
int pop_int(struct list_int_t *list);

struct list_float_t *init_float();
int is_empty_float(struct list_float_t *list);
void push_float(struct list_float_t *list, float value);
float pop_float(struct list_float_t *list);

int main() {
  struct list_int_t *list = init_int();
  for (int i = 0; i < 10; i++) {
    push_int(list, i);
  }
  while (!is_empty_int(list)) {
    int value = pop_int(list);
    printf("%d\n", value);
  }
  struct list_float_t *list2 = init_float();
  for (int i = 0; i < 10; i++) {
    push_float(list2, i + 0.1);
  }
  while (!is_empty_float(list2)) {
    float value = pop_float(list2);
    printf("%f\n", value);
  }
  return 0;
}

struct list_int_t *init_int() {
  struct list_int_t *list = malloc(sizeof(struct list_int_t));
  list->head = NULL;
  return list;
}

struct list_float_t *init_float() {
  struct list_float_t *list = malloc(sizeof(struct list_float_t));
  list->head = NULL;
  return list;
}

int is_empty_int(struct list_int_t *list) {
  return list->head == NULL;
}

int is_empty_float(struct list_float_t *list) {
  return list->head == NULL;
}

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
}

void push_float(struct list_float_t *list, float value) {
  struct node_float_t *new_node = malloc(sizeof(struct node_float_t));
  new_node->value = value;
  new_node->next = NULL;
  if (is_empty_float(list)) {
    list->head = new_node;
    return;
  }
  struct node_float_t *current_node = list->head;
  while (current_node->next) {
    current_node = current_node->next;
  }
  current_node->next = new_node;
}

int pop_int(struct list_int_t *list) {
  if (is_empty_int(list)) { return -1; }
  struct node_int_t *current_node = list->head;
  struct node_int_t *prev_node = NULL;
  while (current_node->next) {
    prev_node = current_node;
    current_node = current_node->next;
  }
  if (prev_node) {
    prev_node->next = NULL;
  } else {
    list->head = NULL;
  }
  return current_node->value;
}

float pop_float(struct list_float_t *list) {
  if (is_empty_float(list)) { return -1; }
  struct node_float_t *current_node = list->head;
  struct node_float_t *prev_node = NULL;
  while (current_node->next) {
    prev_node = current_node;
    current_node = current_node->next;
  }
  if (prev_node) {
    prev_node->next = NULL;
  } else {
    list->head = NULL;
  }
  return current_node->value;
}
