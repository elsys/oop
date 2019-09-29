#ifndef RECTANGLE_HH_
#define RECTANGLE_HH_

#include "Point.hh"
#include "Shape.hh"

class Rectangle: public Shape {
	Point ul_, dr_;
public:
	Rectangle(Point& ul, Point& dr);
	void draw() const;
};


#endif
