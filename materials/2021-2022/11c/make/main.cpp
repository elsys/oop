#include <iostream>
#include <math.h>
#include "point.h"

using std::cout;
using std::cin;
using std::endl;

int main(int argc, char *argv[])
{
    Point* p1 = new Point(0,0);
    Point* p2 = new Point(2,2);

	int dx = p2->getx() - p1->getx();
	int dy = p2->gety() - p1->gety();
	double distance = sqrt( pow(dx, 2) + pow(dy, 2) );

    cout << "Distance between ";
	p1->print();
	cout << " and ";
	p2->print();
	cout << " is " << distance << endl;

	delete p1;
	delete p2;

	return 0;
}
