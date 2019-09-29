#include "point.hh"
#include "rectangle.hh"



// extern int a;
// extern int a;

// class Foo;

int main() {
	// int a=1;
	// int a;

	Point p1(1,2);
	Point p2(2,4);

	p1.print();
	p2.print();	

	Rectangle r(p1, p2);
	r.print();
	
	return 0;
}

