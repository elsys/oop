#include <stdio.h>
#include <stdlib.h>

struct node_t
{
  void *val;
  struct node_t *next;
};

struct node_t* create(void *x)
{
  struct node_t* a = malloc(sizeof(struct node_t));
  a->val = x;
  a->next = NULL;
  
  return a;
}

void print_list(struct node_t* list) {
  struct node_t* curr = list;
  while(curr != NULL){
    printf("%p\n", curr->val);
    curr = curr->next;
  }
}

struct node_t* add_node(struct node_t* node, void *value) {
  struct node_t* new_node = create(value);  
  node->next = new_node;
  
  return new_node;
}

int main()
{
  //struct node_t first = {1, NULL};
  //struct node_t second = {4, NULL};
  //struct node_t* third = create(420);
  
  //first.next = &second;
  //second.next = third;
  
  //printf("%d\n",first.val);
  //printf("%d\n",first.next->val);
  //printf("%d\n",first.next->next->val);
  
  struct node_t* first = create((void *)1);
  struct node_t* last = first;
  last = add_node(last, (void *)4);
  last = add_node(last, (void *)420);
  last = add_node(last, (void *)5);
  
  print_list(first);
  
  return 0;
}


