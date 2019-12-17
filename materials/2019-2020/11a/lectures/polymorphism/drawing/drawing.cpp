#include <iostream>
#include <list>

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
		
		void print() const {
			cout << "(" << x << ", " << y << ")";
		}
};

class Shape {
	public:
		virtual void draw() const=0;
};

class Circle : public Shape {
	Point center;
	int radius;
	public:
		Circle(const Point& center, int radius) {
			this -> center = center;
			this -> radius = radius;
		}
		
		void draw() const {
			cout << "Circle(";
			center.print();
			cout << ", " << radius << ")" << endl;
		}
};

class Rectangle : public Shape {
	Point ul;
	Point br;
	public:
		Rectangle(const Point& ul, const Point& br) {
			this -> ul = ul;
			this -> br = br;
		}
		
		void draw() const {
			cout << "Rectangle(";
			ul.print();
			cout << ", ";
			br.print();
			cout << ")" << endl;
		}
};

void printAll(list<Shape*>& l) {
	for(list<Shape*>::iterator it = l.begin(); it != l.end(); it++) {
		(*it) -> draw();
	}
}

int main() {

	list<Shape*> shapes;
	Point center = Point(1, 2);
	Point ul = Point(3, 4);
	Point br = Point(5, 6);

	Circle c = Circle(center, 5);
	Rectangle r = Rectangle(ul, br);

	Shape s = Shape();

	shapes.push_back(&c);
	shapes.push_back(&r);
	
	printAll(shapes);

	return 0;
}












