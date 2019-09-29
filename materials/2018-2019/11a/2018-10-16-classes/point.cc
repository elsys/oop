

#include <iostream>
using namespace std;


class Point {
	double x_;
	double y_;
	
public:
	Point(double x, double y) {
		x_ = x;
		y_ = y;
	}
	double get_x() const {
		return this->x_;
	}
	double get_y() const {
	
		return this->y_;
	}
	Point& set_x(double x_) {
		this -> x_ = x_;
		return *this;
	}
	Point& set_y(double y) {
		y_ = y;
		return *this;
	}
};


int main() {
	const Point origin(0, 0);
	
	Point p1(1,1), p2(2,2);
	// origin.set_x(2.0);
	cout << origin.get_x() << ", " << origin.get_y() << endl;
	p1.get_x();
	p2.get_y();
	
	cout << p1.get_x() << "," << p1.get_y() << endl;

	(p1.set_x(3.0)).set_y(4.0);
	
	cout << p1.get_x() << "," << p1.get_y() << endl;

	return 0;
}

