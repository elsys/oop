#include <iostream>
using namespace std;

class A {
public:
  A(int a) : field_a(a) {}
  
  int field_a = 10;
};

class B {
public:
  B(int b) : field_b(b) {}
  
  int field_b = 20;
};

class C : public A, public B {
public:
  C(int a, int b) : A(a), B(b) {
    //A::A(a);
    //B::B(b);
  }
};

class D : public A, public C {
public:
  D(int a, int b) : A(a), C(a, b) {}
};

int main() {
//  C my_test = C(5, 15);
  D my_test = D(5, 15);
  cout << my_test.A::field_a << " " << my_test.field_b << endl;
  return 0;
}
