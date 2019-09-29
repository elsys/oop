#include "turtle.hh"

int main() {
	PSTurtle t(200,200);
	
	t.setup().penup().moveto(Point(100,100));
	t.pendown();
	t.set_heading(0).forward(20).set_heading(90).forward(20).set_heading(180).forward(20);
	
	return 0;
}

