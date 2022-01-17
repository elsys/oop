#include <iostream>
using namespace std;
/*
class Class1 {
private:
  int var2;
protected:
  int var3;
public:
  int var;

  // A single constructor in the parent class forces child classes to explicitly call it
  Class1(int var) : var(var) {}
};

// Using an access modifier when inheriting reduces the access modifier of inherrited things
// private causes public and protected things from Class1 to become private in Class2
class Class2 : private Class1 {
private:
  int var3;
  int var;
public:
  Class2() : Class1(5) {}
  Class2(int var) : Class1(var) {}
};*/
/*
// Things not meant or required to be accessed from outside the class should be private
// A good practice is to always define things as private and make them more open as needed
class fstream {
  string filename;
  char access_mode;
  int cursor_index;
  int file_address;
public:
  char getChar();
}*/
/*
// Abstract cell class
class Cell {
  virtual void foo() = 0;
}

// Dynamic array of dynamic arrays of pointers
// 2-dimensional dynamic array of cell pointers
Cell*** matrix;
matrix = new Cell**[width]
for(int i = 0; i < width; i++)
  matrix[i] = new Cell*[height]

// Vector of vectors of pointers
// Also a 2-dimensional dynamic array of cell pointers
vector<vector<Cell*>> matrix
matrix.resize(width)
for(int i = 0; i < width; i++)
  matrix[i].resize(height)

// Staticly defined 2-dymensional array of cell pointers
// Cannot be resized at runtime
Cell*[10][10] matrix

// 1-dimensional array of pointers
// Used as if it was 2-dymensional by calculating correct i indices from x and y
Cell** matrix
matrix = new Cell*[width * height]
*/

class Class1 {
public:
  int var1 = 1;
};

class Class2 : public Class1 {
public:
  int var2 = 2;
};

class Class3 : public Class2 {
public:
  int var3 = 3;

  Class3() : Class2() {}

  // Copy constructor needed when casting from a parent to a child class
  Class3(Class1& other) {
    var1 = other.var1;
    var2 = 2;
    var3 = 3;
  }
};

int main() {
  /*Class2 c2 = Class2();
  Class2 c2_2 = Class2(10);

  cout << c2.var << endl;
  cout << c2_2.var << endl;*/
  /*Class3 c3 = new Class3();
  Class2 c2 = (Class2)c3;
  Class1 c1 = (Class1)c3;*/
  Class3 c3;
  Class2* c2 = (Class2*)&c3;
  Class1* c1 = (Class1*)&c3;

  // This cast will create a new instancec of Class1 by calling its copy constructor and the new instance of Class1 will lose information from Class3
  Class1 c1_2 = (Class1)c3;
  // Class3 does not have a copy constructor for Class1. Class1 lacks some of the information in Class3 and the constructor wouldn't know what to do unless we define the constructor
  Class3 c4 = (Class3)c1_2;

  // The class instance in memory doesn't change when using pointers
  Class3* c3_2 = &c3;
  Class1* c1_3 = c3_2;
  Class3* c3_3 = (Class3*)c1_3;

  cout << c1->var1 << endl;
  return 0;
}


class GC {
  static char* memory;
public:
  static void* allocate(size_t size);
  static void init();
}

// Extra method used to initialize the GC with a single page
void GC::init() {
  GC::memory = new char[1024];
}

void* GC::allocate(size_t size) {
  void* mem_block = find_in_memory(size)
  return mem_block;
}

GC::init();
