#include <iostream>
using namespace std;
#include "turtle.hh"

class Hilbert {
	Turtle& turtle_;
	double step_;
public:

	Hilbert(Turtle& turtle)
	: turtle_(turtle), step_(20)
	{}
	
	void draw_a(int order);
	void draw_b(int order);
	void draw_c(int order);
	void draw_d(int order);
	
	
};

void Hilbert::draw_a(int order) {
	if(order <= 0) {
		return;
	}
	
	draw_d(order-1);
	turtle_.set_heading(180).forward(step_);
	draw_a(order-1);
	turtle_.set_heading(-90).forward(step_);
	draw_a(order-1);
	turtle_.set_heading(0).forward(step_);
	draw_b(order-1);
}

void Hilbert::draw_b(int order) {
	if(order <= 0) {
		return;
	}
	
	draw_c(order-1);
	turtle_.set_heading(90).forward(step_);
	draw_b(order-1);
	turtle_.set_heading(0).forward(step_);
	draw_b(order-1);
	turtle_.set_heading(-90).forward(step_);
}

void Hilbert::draw_c(int order) {
	if(order <= 0) {
		return;
	}
	draw_b(order-1);
	turtle_.set_heading(0).forward(step_);
	draw_c(order-1);
	turtle_.set_heading(90).forward(step_);
	draw_c(order-1);
	turtle_.set_heading(180).forward(step_);
	draw_d(order-1);
	
}
void Hilbert::draw_d(int order) {
	if(order <= 0) {
		return;
	}
	
	draw_a(order-1);
	turtle_.set_heading(-90).forward(step_);
	draw_d(order-1);
	turtle_.set_heading(180).forward(step_);
	draw_d(order-1);
	turtle_.set_heading(90).forward(step_);
	draw_c(order-1);
}


int main() {
	PSTurtle t = PSTurtle(300, 300);
	t.setup().moveto(Point(150,150));
	t.pendown();
	
	Hilbert h(t);
	h.draw_d(3);


	return 0;
}
