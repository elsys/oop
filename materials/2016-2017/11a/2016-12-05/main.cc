#include "Point.hh"
#include "Circle.hh"

int main() {
    Point p1(1, 1);
    p1.print();
    
    Circle c1(Point(0, 0), 2.5);
    c1.draw(); 
    
    return 0;
}
