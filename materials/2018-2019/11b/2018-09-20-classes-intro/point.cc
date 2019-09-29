#include <iostream>

using namespace std;

//struct
// everything by default is public
class Point {
// everything by default is private
		int x_, y_;

public:
		// everything below is public
		Point(int x, int y) {
				x_ = x;
				y_ = y;
		}

		// constructor overloading
		Point() {
				x_ = 0;
				y_ = 0;
		}
		
		void print() {
				cout << "(" << x_ << ", " << y_ << ")" << endl;
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
		
		void move_by(int x, int y) {
				x_ += x;
				y_ += y;
		}
		
		// method overloading
		void move_by(Point p) {
				move_by(p.x_, p.y_);
		}

private:
		// everything below is private
};

int main() {
		Point p1;
		Point p2(-1, 20);
		
		p1.print();
		p2.print();
		
		// won't compile!
		// cout << "x_ of p1:" << p1.x_ << endl;
		cout << "x_ of p1: " << p1.get_x() << endl;
		
		p1.set_y(-3);
		p1.move_by(p2);
		p1.print();
		return 0;
}








