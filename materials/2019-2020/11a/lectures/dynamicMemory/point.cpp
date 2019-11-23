#include <iostream>
using namespace std;

class Point {
	int x;
	int y;
	public:
		Point(){}
		Point(int x, int y) {
			this -> x = x;
			this -> y = y;
		}
		
		Point(const Point& other) {
			x = other.x;
			y = other.y;
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
	Point p1 = Point(2, 3);
	Point p2 = Point(p1);
	
	printPoint(p1);
	printPoint(p2);
	
	Point p3 = p1;
	printPoint(p3);
}

