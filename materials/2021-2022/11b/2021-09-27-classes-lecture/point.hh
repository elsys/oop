#ifndef POINT_HH
#define POINT_HH

class Point {
public:
  float x;
  float y;
private:
  float z;
protected:
  float a;
  
public:
  Point();
  Point(float x, float y, float z);

  void print();
  /*void foo() {
    std::cout << "TEST" << std::endl;
  }*/
  void foo();
};

#endif

