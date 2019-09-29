#ifndef CIRCLE_HH_
#define CIRCLE_HH_

#include "Shape.hh"
#include "Point.hh"

class Circle: public Shape {
	Point center_;
	double radius_;
public:
	Circle(Point center, double radius);
	void draw() const;
};

#endif
