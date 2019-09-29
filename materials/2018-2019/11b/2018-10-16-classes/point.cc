

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
		return x_;
	}
	double get_y() const {
		return y_;
	}

	Point& set_x(double x_) {
		this->x_ = x_;
		return *this;
	}
	Point& set_y(double y) {
		cout << "Echooooo!!!" << endl;
		y_ = y;
		return *this;
	}
};


int main() {
	const Point origin(0.0, 0.0);
	// origin.set_x(2.0);
	origin.get_x();
	
	Point p1(1,1), p2(2,2);
	
	p1.get_x();
	p2.get_y();

	(cout << p1.get_x()) << "," << p1.get_y() << endl;	
	(p1.set_x(11)).set_y(11);
	cout << p1.get_x() << "," << p1.get_y() << endl;	
	
	return 0;
}

