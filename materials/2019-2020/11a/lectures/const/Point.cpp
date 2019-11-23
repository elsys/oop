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
					
					void set_length(int length) {
						this -> length = length;
					}
			};
	private:
		double x;
		double y;
		Line l = Line(1);
		const char name = 'a';
		static int count;
	public:
		Point(double x, double y, char name) : name(name), x(x), y(y) {
		}
	
		Point(double x, double y) : name('c') {
			this->x = x;
			this->y = y;
			count++;
		}
		
		double get_x() const{
			//this -> l.set_length(2);
			return x; 
		}
		
		Point& set_x(double x) {
			this->x = x;
			return *this;
		}
		
		double get_y();
		void set_y( const double y);
		
		void print() const {
			cout << name << ": x: " << x << ", y: ";
			cout << y << " current count: " << count << endl;
		}
		
		static int get_count() {
			return count;
		}
};

double Point::get_y() {
	return y;
}

void Point::set_y(const double y) {
	this->y = y;
}

int Point::count = 0;

void change(Point a, Point& b){
	a.set_x(8);
	b.set_x(9);
}

int main() {
	Point a = Point(2, 3);
	Point b = Point(4,5);
	change(a, b);
	a.print();
	b.print();
	
	Point::Line l = Point::Line(4);
	
	const Point c = Point(8, 9);
	c.print();
	
	Point d = Point (1, 2, 'Q');
	d.print();
	
	cout << "count: " <<Point::get_count() << endl;
	
	Point e = Point(2, 4);
	e.set_x(8).set_y(3);
	e.set_x(2);
	e.set_y(5);
	e.print();
}





