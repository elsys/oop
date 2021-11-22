#include <iostream>
#include <vector>
using namespace std;
#include <cstddef>

#include <stdlib.h>

class Test {
  int a = 4;
  double b = 15.4;
  // Pointer to dynamic memory that needs to be allocated and freed
  int *elements = NULL;
public:
  Test() {
    // Allocate some memory
    elements = new int[a];
  }

  Test(int a, double b) : a(a), b(b) {
    // Allocate some memory
    elements = new int[a];
  }

  // Use the destructor to manually clear any dynamic memory that was allocated manually
  ~Test() {
    cout << "destructor called" << endl;
    delete elements;
    elements = NULL;
  }

  // Override the new operator for this class only.
  // The argument is the size in bytes and the returned result is a pointer to the allocated memory.
  // new is always static even if you omit the keyword.
  static void* operator new(size_t size) {
    cout << "overloaded new called " << size << endl;
    return malloc(size);
  }

  // Same, but for the new[] operator to allocate arrays. size is the size of class multiplied by the size of the array
  static void* operator new[](size_t size) {
    cout << "overloaded new[] called " << size << endl;
    return malloc(size);
  }

  void print() {
    cout << a << " " << b << endl;
  }
};

int main() {
  // sizeof(int) will give us enough bytes for a single int
  // sizeof(int) * n will give us enough bytes for n array of n ints
  /*void* res = malloc(sizeof(int) * n)
  void* res2 = calloc(n, sizeof(int))
  res = realloc(res, sizeof(int) * m);
  free(res); res = NULL;*/

  // Allocate for a single int
  int *a = new int;    // new
  // Allocate an array of ints
  int *b = new int[2]; // new[]
  // Allocate a two-dimentional array of ints
  int (*c)[10] = new int[5][10];
  // Same as above, but auto lets us avoid writing the complicated type definition
  auto d = new int[5][10];
  // The type for auto variables is inferred by the compiler. If a variable isn't initialized then the compiler
  // doesn't know what type to treat it as
  //auto h;
  //h = a;
  //for(list<int>::iterator it = mylist.begin(); ...
  //for(auto it = mylist.begin(); ...

  // Constructors can be called when allocating classes
  vector<int> *g = new vector<int>(5);

  Test *t1 = new Test(5, 2);
  // When working with pointers access properties with ->
  t1->print();

  Test *t2 = new Test[3];

  // delete and delete[] work like new and new[]
  delete a; a = NULL;  // delete
  delete[] b; b = NULL;  // delete[]
  delete[] c;
  delete[] d;
  delete g;
  delete t1;
  delete[] t2;

  return 0;
}
