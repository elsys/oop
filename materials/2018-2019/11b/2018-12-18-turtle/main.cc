#include <iostream>
#include "turtle.hh"

using namespace std;


int main() {
/*
	cout << "newpath" << endl;
	cout << "100 200 moveto" << endl;
	cout << "200 250 lineto" << endl;
	cout << "100 300 lineto" << endl;
	cout << "2 setlinewidth" << endl;
	cout << "stroke" << endl;
*/

	PSTurtle turtle(1000, 800);
	turtle.setup()
				.pensize(3)
				.moveto(Point(100, 200))
				.pendown()
				.moveto(Point(200, 250))
				.pensize(5)
				.moveto(Point(100, 300));
	return 0;
}
