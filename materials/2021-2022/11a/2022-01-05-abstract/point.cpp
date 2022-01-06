#include "point.hh"
#include <iostream>
#include <sstream>

using namespace std;
Point::Point(int x, int y) { this->x = this->y; }
Point::Point() {
  x = 0;
  y = 0;
}

void Point::set_x(int x) { this->x = x; }
void Point::set_y(int y) { this->y = y; }

int Point::get_x() const { return x; }
int Point::get_y() const { return y; }

void Point::print() const {
    cout << "Point(" << x << ", " << y << ")";
}

string Point::to_string() const {
    ostringstream o;
    o << "Point(" << x << ", " << y << ")";
    return o.str();
}