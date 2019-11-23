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
		
		void setX(double x) {
			this -> x = x;
		}
		
		double getY() const {
			return y;
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
		
		Point& mul(const int alpha) {
			x *= alpha;
			y *= alpha;
			return *this;
		}
		
		Point operator+(const Point p) {
			Point result = Point(x + p.getX(), y + p.getY());
			return result;
		}
		
		Point& operator*(const Point p) {
			x *= p.getX();
			y *= p.getY();
			return *this;
		}
		
		Point operator-(const Point p) {
			Point result = Point(x - p.getX(), y - p.getY());
			return result;
		}

		Point operator-() {
			Point result = Point(-x, -y);
			return result;
		}
		
		double operator->*(Point p) {
			cout << "izpolzvan" << endl;
			return 4.0;
		}
		
		Point& operator()(int a) {
			x = a;
			y = a;
			return *this;
		}
		
		Point operator++() {
			++x;
			++y;
			return *this;
		}
		
		//postfix
		Point& operator++(int) {
			x++;
			y++;
			return *this;
		}
};
/*
Point operator-(const Point p1, const Point p2) {
	Point result = Point(p1.getX() - p2.getX(), p1.getY() - p2.getY());
	return result;
}

Point operator-(const Point p) {
	Point result = Point(-p.getX(), -p.getY());
	return result;
}
*/

ostream& operator<<(ostream& out, const Point p) {
	out << "point(" << p.getX() << ", " << p.getY() << ")" <<endl;
	return out;
}


/*
istream& operator>>(istream& in, Point result) {
	string line;
	getline(in, line);
	return in;
}
*/
void printPoint(Point p) {
	cout << "point(" << p.getX() << ", " << p.getY() << ")" << endl;
}

int main() {
	Point p1 = Point(1, 2);
	Point p2 = Point(2, 3);
	
	p1.add(p2).sub(p2).mul(2);
	
	printPoint(p1);
	
	Point p3 = p1 + p2;
	printPoint(p3);
	
	Point p4 = p1 - p2;
	printPoint(p4);
	
	Point p5 = -p4;
	printPoint(p5);
	
	Point p6 = Point(2, 2);
	Point p7 = Point(3, 3);
	
	Point p10(1, 2);
	p10(3);
	cout << "p10: " << p10;
	
	Point p8 = p6 * p7;
	printPoint(p6);
	p8.setX(2);
	printPoint(p8);
	
	cout << "p8: " << p8 << "p7: " << p7;
	
	Point* pp = &p8;
	cout << pp->getX() << endl;
	
	cout << pp->getX() << endl;
	
	Point p12(1, 2);
	cout << "p12: " << ++p12;
	cout << "p12: " << p12++;
}
