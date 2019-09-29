#include "Point.hh"
#include "Circle.hh"
#include "Drawing.hh"


int main() {
    Point p1(1, 1);
    p1.print();
    
    Circle c1(Point(0, 0), 2.5);
    Circle c2(Point(2, 2), 2.5);
    c1.draw(); 
    
    Drawing d1;
    d1.add_shape(&c1);
    d1.add_shape(&c2);
    
    d1.draw();
    
    Drawing d2;
    Circle c3(Point(3,3), 2.5);
    d2.add_shape(&d1);
    d2.add_shape(&c3);
    d2.draw();
    
    
    return 0;
}
