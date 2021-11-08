#include <iostream>

using namespace std;

void foo(int &a, int &b, int &c) {
  a += 4;
  b -= 2;
  c = c + a - b;
}

class Point {
public:
  double x, y;
  
  int const * const foo(int const * const & a) const {
    // ...
  }
};

void bar(const Point &p1, const Point &p2) {
  cout << p1.x;
  //p1.x = 3.5;
}
/*
void baz(int &arr[], int *&arr2) {
}
*/
int main() {
  /*int a = 5;
  int c = 10;
  int d[] = {1,2,3};
  int *b = &a;
  int *e = d;
  
  *b = 7;
  b = &c;
  
  cout << a << endl;
  cout << *b << endl;
  cout << *b + 1 << endl;
  cout << *(b + 1) << endl;
  cout << *(e + 1) << endl;
  
  int aa = 1, bb = 2, cc = 3;
  int &aaa = aa;
  aaa = bb; // => aa = bb;
  foo(aa, bb, cc);
  
  cout << aa << " " << bb << " " << cc << endl;*/
  
  int a = 5;
  const int b = 5;
  int const bb = 5;
  
  int *c = &a;
  const int *d = &b;
  int const *e = &b; // pointer to const int
  //*e = 8;
  
  int * const j = &a; // const pointer to int
  
  const int * const f = &b;
  int const * const g = &b; // const pointer to const int
  
  const int &h = a;
  const int &i = b;
  a += 3;
  //h += 3;
  
  int const * const & k = ???;

  return 0;
}
