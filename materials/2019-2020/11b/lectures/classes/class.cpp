#include <iostream>
#include <cmath>
using namespace std;

class Point {
		int x = 5;
		int y;
	public:
		Point (int x, int y) {
			this->x = x;
			this->y = y;
		}
		
		Point () {};
		int getX() {
			return x;
		};

		int getY() {
			return y;
		};

		void setX(int x);

		double distance(Point b){
			int dx = getX() - b.getX();
			int dy = getY() - b.getY();
			return sqrt(dx * dx + dy * dy);
		}
};

void Point::setX(int x) {
	Point::x = x;
}

int main() {
	Point a = Point(2,3);
	Point b = Point(4,5);
	cout << "Distance: " << a.distance(b) << endl;
}
