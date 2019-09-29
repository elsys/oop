#include <iostream>
#include <cmath>
using namespace std;

class Point {
	double x_;
	double y_;
public:
	Point() {
		cout << "default cntr..." << endl;
		x_ = 0.0;
		y_ = 0.0;
	}

	Point(double x, double y) {
		x_ = x;
		y_ = y;
	}

	double get_x() {
		return x_;
	}

	double get_y() {
		return y_;
	}

	void set_x(double x) {
		x_ = x;
	}

	void set_y(double y) {
		y_ = y;
	}


	void add(Point other) {
		// x_ = x_ + other.x_;
		x_ += other.x_;
		y_ += other.y_;
	}

	void sub(Point other) {
		x_ -= other.x_;
		y_ -= other.y_;
	}

	double dist(Point other) {
		double dx = x_ - other.x_;
		double dy = y_ - other.y_;
		
		return sqrt(dx*dx + dy*dy);
	}

};


int main() {

	Point p1, p2;
	cout << p1.get_x() << ", " << p1.get_y() << endl;
	cout << p2.get_x() << ", " << p2.get_y() << endl;

	// p1.x_ = 10;
	p1.set_x(10.0);
	p1.set_y(20.0);

	cout << p1.get_x() << ", " << p1.get_y() << endl;
	
	p2.set_x(11.0);
	p2.set_y(22.0);
	cout << p2.get_x() << ", " << p2.get_y() << endl;

	cout << p1.get_x() << ", " << p1.get_y() << endl;

	Point p3(12.0, 24.0);
	cout << p3.get_x() << ", " << p3.get_y() << endl;
	
	cout << p1.get_x() << ", " << p1.get_y() << endl;
	p1.add(p2);
	cout << p1.get_x() << ", " << p1.get_y() << endl;
	
	return 0;
}

