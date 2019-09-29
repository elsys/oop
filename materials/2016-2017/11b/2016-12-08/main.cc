#include "Point.hh"
#include "Shape.hh"
#include "Circle.hh"
#include "Rectangle.hh"

int main() {
	Point p1(1, 0);
	p1.print();
	
	Circle c1(p1, 12);
	Shape& s1 = c1;
	s1.draw();
	
	Point p2 = Point(5, -2);
	Rectangle r1(p1, p2);
	r1.draw();
	
	s1 = r1;
	s1.draw();
	return 0;
}
