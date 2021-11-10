#include <iostream>

using namespace std;

void foo() {
  static int counter = 1;
  //cout << (counter+=1) << endl;
  //cout << ++counter << endl;
  
  //cout << counter << endl; counter += 1;
  cout << counter++ << endl;
}

class Point {
public:
  int x, y;
  
  static unsigned int instance_counter;
  const static int counter2 = 4;
  
  static void foo() {
    cout << "i am static"  << endl;
    cout << counter2 << endl;
  }
  
  /*Point() {
    instance_counter++;
    x = 0; y = 0;
  }
  
  Point(int v) {
    instance_counter++;
    x = v; y = v;
  }
  
  Point(int x, int y) {
    instance_counter++;
    this->x = x; 
    this->y = y;
  }*/
  Point() : Point(0, 0) {
    //Point(0, 0);
  }
  
  Point(int v) : Point(v, v) {}
  
  /*Point(float v) {
    Point(v, v);
  }*/
  
  Point(int x, int y) : x(x), y(y) {
    instance_counter++;
  }
  
  void bar() {
  }
};

unsigned int Point::instance_counter = 0;

int main() {
  foo();
  foo();
  foo();
  foo();
  
  //Point::instance_counter = 5;
  Point p1, p2(5), p3(3,7);
  cout << p1.instance_counter << endl;
  cout << Point::instance_counter << endl;
  
  //p1.foo();
  Point::foo();
  
  p1.bar();
  //Point::bar();
  
  return 0;
}
