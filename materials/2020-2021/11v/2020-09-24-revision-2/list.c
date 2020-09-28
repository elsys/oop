#include <stdio.h>
#include <stdlib.h>

struct node_t{

  int value;
  struct node_t* next;

};

struct node_t* create_element(int value){

  struct node_t* head = malloc(sizeof(struct node_t));
  head->value = value;
  head->next = NULL;
  
  
  return head;
}
struct node_t* add_element(struct node_t* node, int val)
{
  struct node_t *new_el = create_element(val);
  node->next = new_el;
  return new_el;
}
void print_list(struct node_t* node){

  //struct node_t *current;
  //current = node;
  while(node != NULL){
        printf("%d\n", node->value);
        node = node->next;
  }

}


int main(){
  struct node_t* tail;
  struct node_t* node1 = create_element(1);
  tail = add_element(node1, 2);
  tail = add_element(tail,3);
  //struct node_t node2;
  //struct node_t node3;
  //struct node_t node4;
  //node1.value = 1;
  //node2.value = 2;
  //node3.value = 3;
  //node4.value = 4;
  //node1->next = &node2;
  //node2.next = &node3;
  //node3.next = &node4;
  //node4.next = NULL;
 // printf("%d\n", node1.value);
 // printf("%d\n", node1.next->value);
 // printf("%d\n", node1.next->next->value);
  //printf("%d\n", node1.next->next->next->value);
  print_list(node1);
  
  return 0;
}
