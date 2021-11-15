#include <iostream>
using namespace std;

void foo(int *arg) {
  *arg += 4;
}

void bar(int &arg) {
  arg += 8;
}

class Point {
  float x, y;
public:
  Point& operator+=(const Point& other) {
    x += other.x;
    //other.x += 1;
    y += other.y;
    return this;
  }
};

Point p1, p2;
p1 += p2; // operator+=

int main () {
  int a = 5;
  int *b = &a;
  int c = 7;

  cout << *b << endl;
  *b += 3;
  cout << a << endl;

  foo(&a);
  cout << a << endl;

  int &d = a;
  d += 5;
  cout << a << endl;

  bar(a);
  cout << a << endl;

  return 0;
}
