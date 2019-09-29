#include <stdlib.h>
#include <iostream>
using namespace std;

template<class T>
class Vector {
  T *items;
public:
  Vector() {
    count = 0;
    items = NULL;
  }
  int count;
  void push(T new_item) {
    items = (T*)realloc(items, (sizeof(T)*(++count)));
    items[count-1]=new_item;
  }
  int is_empty(){
    if(count<=0){
      return 1;
    }
    return 0;
  }
  int pop(T *popped_item) {
    if(is_empty()){
      return 0;
    }
    *popped_item = items[--count];
    return 1;
  }
  void empty() {
    free(items);
    count = 0;
  }
  /*void init() {
    count = 0;
    items = NULL;
  }*/
};
/*
void init(struct vector_t *vector){
  vector->count=0;
  vector->items = NULL;
}*/

/*void push(struct vector_t *vector, int new_item){
  vector->items = (int*)realloc(vector->items, (sizeof(int)*(++vector->count)));
  vector->items[vector->count-1]=new_item;
}*/

int main() {
  Vector<int> v1;
  //Vector v2 = Vector();
  //Vector *v3 = new Vector();
  //v1.init();
  v1.push(12);
  v1.push(36);
  v1.push(36);
  cout << v1.count << endl;
  int popped_item;
  while(!v1.is_empty()){
    v1.pop(&popped_item);
    printf("Popped item: %d\n", popped_item);
  }

  Vector<float> v2;
  v2.push(12.5);
  v2.push(36.5);
  v2.push(36.5);
  cout << v2.count << endl;
  float popped_item2;
  while(!v2.is_empty()){
    v2.pop(&popped_item2);
    printf("Popped item: %f\n", popped_item2);
  }
  return 0;
}
