#include "Point.hh"
#include "Circle.hh"
#include <iostream>

Circle::Circle(Point& center, double radius)
	: center_(center), radius_(radius) {}

void Circle::draw() const {
	std::cout << "Circle(center=(" << center_.get_x() << ","
			  << center_.get_y() << "),radius=" << radius_ << ")"
			  << std::endl;
}
