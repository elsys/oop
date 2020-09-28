#include <stdio.h>
#include <stdlib.h>
struct node_t
{
  int val;
  struct node_t* next; 
};

void print_list(struct node_t el)
{
  printf("%d\n", el.val);

  while(el.next != NULL)
  {
    printf("%d\n", el.next->val);
    el.next = el.next->next;
  }

}
struct node_t* create_element(int value){
  struct node_t* new_node = malloc(sizeof(struct node_t));
  new_node->val = value;
  new_node->next = NULL;
  return new_node;
}
struct node_t* add(struct node_t* prev, int value){
  struct node_t* new_node = create_element(value);
  prev->next = new_node;
  return new_node;
}


int main()
{ 
  struct node_t* my_list = create_element(5);
  struct node_t* tail = add(my_list, 6);
  tail = add(tail, 8);
  print_list(*my_list);
  /*struct node_t el1;
  struct node_t el2;
  struct node_t el3;
  struct node_t el4;
  struct node_t el5;
  el1.val = 6;
  el2.val = 8;
  el3.val = 1;
  el4.val = 2;
  el5.val = 3;
  el1.next = &el2;
  el2.next = &el3;
  el3.next = &el4;
  el4.next = &el5;
  el5.next = NULL;
  printf("%d\n", el1.val);
  printf("%d\n", el1.next->val);
  printf("%d\n", el1.next->next->val);
  printf("%d\n", el1.next->next->next->val);
  printf("%d\n", el1.next->next->next->next->val);
  
  print_list(el1);*/
  return 0;
}
