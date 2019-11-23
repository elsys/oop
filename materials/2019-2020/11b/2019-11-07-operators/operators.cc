#include <iostream>
using namespace std;

int max(int a, int b) {
  return a > b ? a : b;
}

int min(int a, int b) {
  return a < b ? a : b;
}

class Rectangle {
  public:
  int x;
  int y;
  int h;
  int w;
  
  Rectangle() : x(0), y(0), h(0), w(0) {}
  Rectangle(int x, int y, int h, int w) : x(x), y(y), h(h), w(w) {}
  
  Rectangle operator+(int other) {
    return Rectangle(x + other, y + other, h + other, w + other);
  }
  
  void operator+=(int other) {
     x += other;
     y += other;
     h += other;
     w += other;
  }
  
  Rectangle operator+(Rectangle other) {
    int left = min(x, other.x);
    int top = max(y, other.y);
    int right = max(x + w, other.x + other.w);
    int bottom = min(y - h, other.y - other.h);
    
    return Rectangle(left, top, top - bottom, right - left);
  }
  
  void operator+=(Rectangle other) {
    int left = min(x, other.x);
    int top = max(y, other.y);
    int right = max(x + w, other.x + other.w);
    int bottom = min(y - h, other.y - other.h);    
    
    x = left;
    y = top;
    h = top - bottom;
    w = right - left;
  }
};

int main() {
  Rectangle r1;
  r1 += 5;
  Rectangle r2(6, 6,  5, 5);
  r1 += r2;
  
  cout << r1.x << " " << r1.y << " "  << r1.h  << " " << r1.w << " "  << endl;
  return 0;
}
