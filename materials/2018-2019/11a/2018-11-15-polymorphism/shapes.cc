#include <cmath>
#include <vector>
#include <iostream>

using namespace std;

class Point {
	double x_, y_;
	
public:
	
	Point(double x=0.0, double y=0.0)
		: x_(x), y_(y) {}
	
	double get_x() const {
		return x_;
	}
	
	double get_y() const {
		return y_;
	}
	
	bool isUpper(const Point& other) const {
		return y_ < other.y_;
	}
	
	bool isLefter(const Point& other) const {
		return x_ < other.x_;
	}

};

class ShapeException {};

class Shape {
public:
	virtual double area() const = 0;
};

class Circle : public Shape {
	double r_;
	Point c_;
	
public:
	
	Circle(double r, const Point& c)
		: r_(r), c_(c) {}
	
	double area() const {
		return M_PIl * r_ * r_;
	}
};

class Rectangle : public Shape {
	Point topLeft_, bottomRight_;

public:

	Rectangle(const Point& topLeft, const Point& bottomRight)
		: topLeft_(topLeft), bottomRight_(bottomRight) {
			if (!topLeft_.isUpper(bottomRight_) || !topLeft_.isLefter(bottomRight_)) {
				throw ShapeException();
			}
	}
		
	double area() const {
		return (bottomRight_.get_x() - topLeft_.get_x())
			* (bottomRight_.get_y() - topLeft_.get_y());
	}
};

// 1. add new method draw()
// 2. add new Shape -> Triangle

int main() {
	
	vector<Shape*> shapes;
	// won't compile!!
	//shapes.push_back(new Shape());
	shapes.push_back(new Circle(10, Point(10, 10)));
	shapes.push_back(new Rectangle(Point(1, 1), Point(4, 7)));
	
	for (vector<Shape*>::iterator it = shapes.begin();
			 it != shapes.end(); it++) {
		cout << (*it) -> area() << endl;
	}
	return 0;
}










