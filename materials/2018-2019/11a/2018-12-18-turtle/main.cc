#include <iostream>
#include "turtle.hh"

using namespace std;

int main() {
/*
	cout << "newpath" << endl;
	cout << "100 200 moveto" << endl;
	cout << "200 250 lineto" << endl;
	cout << "100 300 lineto" << endl;
	cout <<	"2 setlinewidth" << endl;
	cout << "stroke" << endl;
*/
	
	PSTurtle turtle = PSTurtle(1080, 768);
	turtle.setup()
			 .pensize(2)
			 .moveto(Point(100, 200))
			 .pendown()
			 .moveto(Point(200, 250))
			 .moveto(Point(100, 200));
	
	return 0;
}
