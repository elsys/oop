//#include <stdio.h>
#include <iostream>
  using namespace std;
  
#include "point.hh"

/*
class Point {
public:
  float x = 1.0;
  float y = 2.0;
private:
  float z = 0.0;
protected:
  float a = 0.0;
  
public:
  Point() {
    x = 0.0;
    y = 0.0;
    z = 0.0;
  }
  
  Point(float x, float y, float z) {
    this->x = x;
    this->y = y;
    this->z = z;
  }

  void print() {
    cout << x << " " << y << " " << z << endl;
  }
  
  /*void foo() {
    std::cout << "TEST" << std::endl;
  }*
  void foo();
};
*/
class Point2 : Point {
private:
  float a = 0.0;
public:
  void print() {
    cout << x << " " << y  << " " << a << endl;
  }
};  
/*
class Point3 : Point2 {
public:
  void print() {
    cout << x << " " << y  << " " << a << endl;
  }
};
*/
/*void Point::foo() {
  std::cout << "TEST in class" << std::endl;
}
*/
void foo() {
  std::cout << "TEST outside class" << std::endl;
}

int main() {  
  //using namespace std;
  //printf("Hello world\n");
  //std::cout << "Hello world" << std::endl;
  /*cout << "Hello world" << endl;
  foo();
  
  int a = 5;
  cin >> a;
  
  cout << a << " " << &a << endl;*/
  
  Point p1;
  //cout << p1.x << " " << p1.z << endl;
  p1.x = 5;
  p1.print();
  
  //Point p2 = Point(2, 3, 4);
  Point p2(2, 3, 4);
  p2.print();
  
  p1.foo();
  
  return 0;
}

