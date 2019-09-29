#include "Rectangle.hh"
#include <iostream>

Rectangle::Rectangle(Point& ul, Point& dr)
	: ul_(ul), dr_(dr) {}

void Rectangle::draw() const {
	std::cout << "Rectangle..." << std::endl;
}
