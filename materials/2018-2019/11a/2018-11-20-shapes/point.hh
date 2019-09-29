#ifndef POINT_HH__
#define POINT_HH__


class Point {
	double x_, y_;
public:
	Point(double x=0.0, double y=0.0)
	: x_(x), y_(y)
	{}
	
	double get_x() const {
		return x_;
	}
	
	double get_y() const {
		return y_;
	}
	
	Point& set_x(double x) {
		x_ = x;
		return *this;
	}
	Point& set_y(double y) {
		y_ = y;
		return *this;
	}
	
	void print() const;

};

#endif

