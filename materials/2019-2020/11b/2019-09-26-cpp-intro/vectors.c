#include <stdio.h>
#include <stdlib.h>

struct vector_t{
  int count;
  int *items;
};

struct vectorchar_t{
  int count;
  char *items;
};

void init(struct vector_t *vector){
  vector->count=0;
  vector->items = NULL;
}

void init_char(struct vectorchar_t *vector){
  vector->count=0;
  vector->items = NULL;
}

void push(struct vector_t *vector, int new_item){
  vector->items = (int*)realloc(vector->items, (sizeof(int)*(++vector->count)));
  vector->items[vector->count-1]=new_item;
}

void push_char(struct vectorchar_t *vector, char new_item){
  vector->items = (char*)realloc(vector->items, (sizeof(char)*(++vector->count)));
  vector->items[vector->count-1]=new_item;
}

int is_empty_char(struct vectorchar_t *vector){
  if(vector->count<=0){
    return 1;
  }
  return 0;
}

int is_empty(struct vector_t *vector){
  if(vector->count<=0){
    return 1;
  }
  return 0;
}

int pop(struct vector_t *vector, int *popped_item){
  if(is_empty(vector)){
    return 0;
  }
  *popped_item = vector->items[--vector->count];
  return 1;
}

int pop_char(struct vectorchar_t *vector, char *popped_item){
  if(is_empty_char(vector)){
    return 0;
  }
  *popped_item = vector->items[--vector->count];
  return 1;
}

void empty(struct vector_t *vector){
  free(vector->items);
  vector->count = 0;
}

void empty_char(struct vectorchar_t *vector){
  free(vector->items);
  vector->count = 0;
}

int main(){
  struct vector_t vector;
  struct vectorchar_t vectorchar;
  init(&vector);
  init_char(&vectorchar);
  push(&vector,12);
  push(&vector,36);
  push(&vector,36);
  push_char(&vectorchar,'a');
  push_char(&vectorchar,'b');
  push_char(&vectorchar,'c');
  int popped_item;
  char popped_char_item;
  while(!is_empty(&vector)){
    pop(&vector, &popped_item);
    printf("Popped item: %d\n", popped_item);
  }
  while(!is_empty_char(&vectorchar)){
    pop_char(&vectorchar, &popped_char_item);
    printf("Popped char item: %c\n", popped_char_item);
  }
  empty(&vector);
  empty_char(&vectorchar);
  return 0;
}
