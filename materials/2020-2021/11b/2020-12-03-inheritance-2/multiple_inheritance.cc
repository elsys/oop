#include <iostream>
using namespace std;

class A {
public:
  A(int a) : field_a(a) {}
  int field_a;
};

class B {
public:
  B(int b) : field_b(b) {}
  int field_b;
};

class C : public A, public B {
public:
  C(int a, int b) : A(a), B(b) {}
};

class D : public A, public C {
public:
  D(int a, int b) : A(a), C(a, b) {}
};

int main() {
  C my_test = C(15, 5);
  
  cout << my_test.field_a << " " << my_test.field_b << endl;
  
  D my_d = D(65, 74);
  cout << my_d.C::field_a << " " << my_d.field_b << endl;
  
  return 0;
}
