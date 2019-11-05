#include <iostream>
using namespace std;

class Point {
	double x;
	double y;
	public:
		Point() {}
		Point(double x, double y) {
			this -> x = x;
			this -> y = y;
		}
		
		double getX() const {
			return x;
		}
		
		double getY() const {
			return y;
		}
		
		void setX(double x) {
			this -> x = x;
		}
		
		void setY(double y) {
			this -> y = y;
		}
		
		Point& add(const Point p) {
			x += p.getX();
			y += p.getY();
			return *this;
		}
		
		Point& sub(const Point p) {
			x -= p.getX();
			y -= p.getY();
			return *this;
		}
		
		Point& mul(int alpha) {
			x *= alpha;
			y *= alpha;
			return *this;
		}
		
		Point operator+(const Point p) {
			Point result = Point(x + p.getX(), y + p.getY());
			return result;
		}
		
		Point operator*(double alpha) {
			Point result = Point(x * alpha, y * alpha);
			return result;
		}
		
		Point& operator+=(const Point p) {
			x += p.getX();
			y += p.getY();
			return *this;
		}
		
		void operator()(double a) {
			x += a;
			y += a;
		}
		
		void operator,(int a) {
			x = a;
			y = a;
		}
};

void operator~(Point& a) {
	a.setX(5);
	a.setY(5);
}

ostream& operator<<(ostream& out, const Point p) {
	out << "point(" << p.getX() << ", " << p.getY() << ")" << endl;
	return out;
}

Point operator-(const Point p1, const Point p2) {
	Point result = Point(p1.getX() - p2.getX(), p1.getY() - p2.getY());
	return result;
}

Point operator-(const Point p) {
	Point result = Point(-p.getX(), -p.getY());
	return result;
}

void printPoint(const Point p) {
	cout << "point(" << p.getX() << ", " << p.getY() << ")" << endl;
}

int main() {
	Point p1 = Point(1, 2);
	Point p2 = Point(2, 3);
	
	p1.add(p2).sub(p2).mul(2);
	/*
	p1.add(p2);
	p1.sub(p2);
	p1.mul(2);
	*/
	printPoint(p1);
	
	Point p3 = Point(3, 4);
	Point p4 = p2 + p3;
	//Point p41 = p2.operator+(p3);
	printPoint(p4);
	
	Point p5 = p4 - p3;
	Point p51 = operator-(p4, p3);
	printPoint(p5);
	
	Point p6 = -p5;
	printPoint(p6);
	
	Point p7 = Point(1, 2);
	Point p8 = p7 * 2;
	printPoint(p8);
	cout << endl;
	printPoint(p5);
	printPoint(p6);
	printPoint(p7);
	printPoint(p8);
	p8 += p7 += p6 += p5;
	cout << endl;
	printPoint(p5);
	printPoint(p6);
	printPoint(p7);
	printPoint(p8);
	
	p8(3);
	cout << p8;
	p8,2;
	cout << p8;
}
 
