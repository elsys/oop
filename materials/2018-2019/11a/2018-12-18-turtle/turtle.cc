#include <cmath>
#include "turtle.hh"

using namespace std;

Point Point::polar(double angle, double distance) {
	return Point(cos(angle) * distance, sin(angle) * distance);
}

Point Point::cartesian(double x, double y) {
	return Point(x, y);
}

ostream& operator<<(ostream& out, const Point& point) {
	out << point.get_x() << " " << point.get_y();
	return out;
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



