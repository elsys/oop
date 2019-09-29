#include <iostream>

using namespace std;

// struct Point
// default visibility is public
class Point {

		int x_, y_;
		
public:
// everything below is public
		// no return type
		Point() {
				x_ = 0;
				y_ = 0;
		}
		
		Point(int x, int y) {
				x_ = x;
				y_ = y;
		}
// If "public:" is here, constructors will be private.
// This will prevent the user from creating instances of Point.
// public:

		void print() {
				cout << "(" << x_ << ", " << y_ << ")" << endl;
		}
		
		void move_by(Point p) {
				// it's better to use getters of p
				move_by(p.x_, p.y_);
		}
		
		// method overloading
		void move_by(int x, int y) {
				x_ += x;
				y_ += y;
				// it's better to use setters:
				// set_x(x_ + x);
				// set_y(y_ + x);
		}
		
		int get_x() {
				return x_;
		}
		
		void set_x(int x) {
				x_ = x;
		}
		
		int get_y() {
				return y_;
		}
		
		void set_y(int y) {
				y_ = y;
		}

private:
		// everything below will be private
};


int main() {
			
		Point p1;
		p1.print();
		
		// won't compile
		// cout << p1.x_ << endl;
		
		cout << "x of p1: " << p1.get_x() << endl;
		
		Point p2(10, 11);
		p2.print();
	
		// wrong: Point::set_x(100);
		// correct:
		p1.set_x(100);
		
		
		p2.move_by(p1);
		p2.print();
		
		return 0;
}







