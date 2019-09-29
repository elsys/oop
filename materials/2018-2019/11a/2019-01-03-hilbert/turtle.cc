#include <cmath>
#include "turtle.hh"

using namespace std;

Point Point::polar(double angle, double distance) {
	double a = angle * M_PI/180.0;
	return Point(cos(a) * distance, sin(a) * distance);
}

Point Point::cartesian(double x, double y) {
	return Point(x, y);
}

ostream& operator<<(ostream& out, const Point& point) {
	out << point.get_x() << " " << point.get_y();
	return out;
}

Point operator+(const Point& p1, const Point& p2) {
	Point result(p1);
	result+= p2;
	return result;
}

PSTurtle::~PSTurtle() {
	out_ << "stroke" << endl;
}

Turtle& PSTurtle::setup() {
	out_ << "newpath" << endl;
	return *this;
}

Turtle& PSTurtle::moveto(const Point& pos) {
	out_ << pos << " ";
	if (is_pendown()) {
		out_ << "lineto";
	} else {
		out_ << "moveto";
	}
	out_ << endl;
	return Turtle::moveto(pos);
}

Turtle& PSTurtle::pencolor(const Color& c) {
	return *this;
}

Turtle& PSTurtle::pensize(double width) {
	out_ << width << " setlinewidth" << endl;
	return *this;
}

Turtle& PSTurtle::dot(double size) {
	return *this;
}



