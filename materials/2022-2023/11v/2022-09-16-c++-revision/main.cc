#include <iostream>

using namespace std;

class MyClass {
private:
  int var1 = 0;
protected:
  int var2 = 0;
public:
  int var3 = 0;

  const int operator==(const MyClass& other) const;
};

class MyClass2 : public MyClass {
public:
  MyClass2() {
    //this->var1 = 1;
    this->var2 = 1;
    this->var3 = 1;
  }
};

int main() {
  MyClass o1;
  MyClass o2 = MyClass();
  MyClass* o3 = new MyClass();
  delete o3;

  MyClass2 o4;
  MyClass* o5 = new MyClass2();
  //ns1::ns2::ns3::foo()
  cout << "Hello" << endl;
  cout << o4.var3 << endl;

  const int* a;
  int* const b;
  const int* const c;

  return 0;
}



