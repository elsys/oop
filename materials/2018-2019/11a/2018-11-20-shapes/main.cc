
#include "point.hh"
#include "rectangle.hh"

/*
void f(int b) {
	cout << b << endl;
}
*/

// void f(int b);


// class Point;

int main() {
	// int a=1;
	// extern int a;
	// extern int a;
	// extern Point a;

	Point p1(1,2);
	Point p2(2,4);
	
	p1.print();
	p2.print();

	Rectangle r(p1, p2);
	r.print();

	return 0;	
}
