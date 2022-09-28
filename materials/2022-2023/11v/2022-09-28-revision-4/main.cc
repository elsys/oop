// class Class1 {
// public:
//   void foo();
// }

// class Class2 : public Class1 {
// public:
//   void foo() {
//     cout << "abstraction/overriding example" << endl;
//   }

//   void foo(int arg) {
//     cout << "overloading example" << endl;
//   }
// }

#include <stdlib.h>
#include <string.h>

class Vector {
  unsigned int capacity = 0;
  unsigned int size = 0;
  int *data = NULL;
public:
  Vector() {}
  Vector(unsigned int capacity) {
    this->capacity = capacity;
    this->data = new int[capacity];
  }
  ~Vector() {
    delete[] data;
  }

  void resize(unsigned int new_capacity) {
    if(new_capacity < size)
      size = new_capacity;

    if(new_capacity > capacity) {
      int *old_data = data;
      data = new int[new_capacity];
      //for(int i = 0; i < capacity; i++)
      //  data[i] = old_data[i];
      memcpy(old_data, data, capacity * sizeof(int));
      delete[] old_data;
    }

    capacity = new_capacity;
  }

  void add(int value) {
    if(size >= capacity) {
      resize(capacity == 0 ? 1 : capacity * 2);
    }

    data[size++] = value;
  }

  void remove() {
    if(size == 0) return;

    size--;
    data[size] = 0;
  }

  int& operator[] (const int index) {
    if(index >= size)
      throw "index out of bounds";

    return data[index];
  }
};

#include <iostream>
using namespace std;

int main() {
  Vector v1;
  Vector v2 = Vector(5);

  v1.add(3);
  v1.add(5);
  v1.add(7);

  v2.add(3);
  v2.add(5);
  v2.add(7);

  v1.resize(10);
  v1.resize(5);

  v2.resize(10);
  v2.resize(2);

  try {
    cout << v1[0] << endl;
    v1[0] = 15;
    cout << v1[0] << endl;
  } catch(char *err) {
    cout << err << endl;
  }

  return 0;
}














