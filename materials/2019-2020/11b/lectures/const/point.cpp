#include <iostream>
using namespace std;

class Point {
	public:
		class Line {
			int length;
			public:
				Line (int length) {
					this -> length = length;
				}
				
				int get_length() {
					return length;
				}
		};
	private:
		double x;
		double y;
		const char name = 'A';
		Line l = Line(2);
		static int count;
	public:
		Point (double x, double y, const char nameA) : x(x), y(y), name(nameA) {
			count++;
		}
		
		Point (double x, double y) {
			this -> x = x;
			this -> y = y;
			count++;
		}
		
		double get_x() const {
			return x;
		}
		
		Point& set_x(double x) {
			this -> x = x;
			return *this;
		}
		
		double get_y() const;
		
		Point& set_y(double y);
		
		void print() const {
			cout << name << ": X: " << x << ", Y: " << y << endl;
		}
		
		void test() {
			Line l2 = Line(2);
		}
		
		static int get_count() {
			return count;
		}
};

double Point::get_y() const {
	return y;
}

Point& Point::set_y(double y) {
	this -> y = y;
	return *this;
}

void change(Point a, Point& b) {
	a.set_x(8);
	b.set_x(9);
}

int Point::count = 0;

int main() {
	Point a = Point(2, 3, 'A');
	a.print();
	
	Point b = Point(3, 4, 'B');
	//cout << b.get_x() << endl;
	b.print();
	
	change(a, b);
	a.print();
	b.print();
	
	Point::Line l = Point::Line(3);
	
	cout << Point::get_count() << endl;
	cout << b.get_count() << endl;
	
	Point c = Point(6,7, 'C');
	c.set_x(3).set_y(2);
	//c.set_x(3);
	//c.set_y(2);
	c.print();
}
