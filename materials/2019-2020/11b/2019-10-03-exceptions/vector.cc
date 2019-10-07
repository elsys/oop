#include <stdlib.h>
#include <iostream>
using namespace std;

class VectorPushException : exception {
public:
  const char* what() {
    return "VectorPushException";
  }
};

class VectorPopException : exception {
public:
  const char* what() {
    return "VectorPopException";
  }
};

class VectorValueException : exception {
public:
  const char* what() {
    return "VectorValueException";
  }
};

class Vector {
  int *items;
  int max_count;
  int max_value;
public:
  int count;

  Vector() {
    items = NULL;
    max_count = 10;
    max_value = 1000;
    count = 0;
  }
  Vector(int m_count, int m_value) {
    items = NULL;
    max_count = m_count;
    max_value = m_value;
    count = 0;
  }
  void push(int new_item) {
    if(new_item >= max_value) { throw VectorValueException(); }
    if(count >= max_count) { throw VectorPushException(); }

    items = (int*)realloc(items, (sizeof(int)*(++count)));
    items[count-1]=new_item;
  }
  int is_empty(){
    if(count<=0){
      return 1;
    }
    return 0;
  }
  int pop() {
    if(is_empty()) { throw VectorPopException(); }

    return items[--count];
  }
  void empty() {
    free(items);
    count = 0;
  }
};

int main() {
  Vector v1(15, 100); // max_count == 15, max_value == 100
  Vector v2; // max_count == 10, max_value == 1000

  try {
    for (int i = 0; ; i++) {
      v1.push(i * 12);
      cout << "Pushed item: " << i * 12 << endl;
    }
  } catch (VectorValueException ex) {
    cout << "Caught exception: " << ex.what() << endl;
  } catch (VectorPushException ex) {
    cout << "Caught exception: " << ex.what() << endl;
  } catch (exception ex) {
    cout << "Caught another exception" << endl;
  }

  cout << v1.count << endl;
  try {
    int popped_item;
    while (1) {
      popped_item = v1.pop();
      cout << "Popped item: " << popped_item << endl;
    }
  } catch (VectorPopException ex) {
    cout << "Caught exception: " << ex.what() << endl;
  } catch (exception ex) {
    cout << "Caught another exception" << endl;
  }

  return 0;
}
