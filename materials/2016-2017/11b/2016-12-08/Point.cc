#include <iostream>
#include "Point.hh"

Point::Point(double x, double y) :
    x_(x), y_(y) {}

double Point::get_x() const {
    return x_;
}

double Point::get_y() const {
	return y_;
}

Point& Point::set_x(double x) {
	x_ = x;
	return *this;
}

Point& Point::set_y(double y) {
	y_ = y;
	return *this;
}

void Point::print() const {
	std::cout << "Point(" << x_ << ", " << y_ << ")" << std::endl;
}
