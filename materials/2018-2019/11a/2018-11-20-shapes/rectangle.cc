

#include "rectangle.hh"

#include <iostream>
using namespace std;


void Rectangle::print() const {
	cout << "Rect(" << endl;
	ul_.print();
	br_.print();
	cout << ")" << endl;
}
