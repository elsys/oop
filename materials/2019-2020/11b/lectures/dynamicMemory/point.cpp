#include <iostream>
using namespace std;

class Point {
	int x;
	int y;
	
	public:
		Point(int x, int y) {
			this -> x = x;
			this -> y = y;
		}
		
		Point(const Point& p) {
			x = p.x;
			y = p.y;
		}
		
		void setX(int x) {
			this -> x = x;
		}
		
		int getX() const {
			return x;
		}
		
		void setY(int y) {
			this -> y = y;
		}
		
		int getY() const {
			return y;
		}
		
		Point& operator=(const Point& p) {
			x = p.x;
			y = p.y;
			return *this;
		}
};

void printPoint(const Point& p) {
	cout << "Point(" << p.getX() << ", " << p.getY() << ")" << endl;
}

int main() {
	Point p1 = Point(1, 2);
	Point p2 = Point(p1);
	
	Point* p3 = new Point(1, 2);
	
	printPoint(p1);
	printPoint(p2);
	
	Point p4 = p1;
	printPoint(p4);
}
