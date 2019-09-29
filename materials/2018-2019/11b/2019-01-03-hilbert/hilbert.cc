#include <iostream>
#include "turtle.hh"

using namespace std;

class Hilbert {
    Turtle& turtle_;
    double step_;
    Point center_;
    double width_;

public:
    Hilbert(Turtle& turtle, Point center, double width)
        : turtle_(turtle), step_(20.0), center_(center), width_(width) {}

    void draw_a(int order);
    void draw_b(int order);
    void draw_c(int order);
    void draw_d(int order);

    void draw(int order);
    double calc_step(int order);
};

double Hilbert::calc_step(int order) {
    if(order <= 0)
        return 0.0;
    double step = width_;

    while(--order > 0) {
        step /= 2.0;
    }

    return step;
}

void Hilbert::draw(int order) {
    Point p0 = center_;
    for(int i = 1; i <= order; i++) {
        step_ = calc_step(order);
        p0 += Point(step_ / 2.0, step_ / 2.0);
        turtle_.penup();
        turtle_.moveto(p0);
        turtle_.pendown();

        draw_a(i);
    }
}

void Hilbert::draw_a(int order) {
    if(order <= 0) {
        return;
    } else {
        draw_d(order-1);
        turtle_.set_heading(180).forward(step_);
        draw_a(order-1);
        turtle_.set_heading(-90).forward(step_);
        draw_a(order-1);
        turtle_.set_heading(0).forward(step_);
        draw_b(order-1);
    }
}

void Hilbert::draw_b(int order) {
    if(order <= 0) {
        return;
    } else {
        draw_c(order-1);
        turtle_.set_heading(90).forward(step_);
        draw_b(order-1);
        turtle_.set_heading(0).forward(step_);
        draw_b(order-1);
        turtle_.set_heading(-90).forward(step_);
        draw_a(order-1);
    }
}

void Hilbert::draw_c(int order) {
    if(order <= 0) {
        return;
    } else {
        draw_b(order-1);
        turtle_.set_heading(0).forward(step_);
        draw_c(order-1);
        turtle_.set_heading(90).forward(step_);
        draw_c(order-1);
        turtle_.set_heading(180).forward(step_);
        draw_d(order-1);
    }
}

void Hilbert::draw_d(int order) {
    if(order <= 0) {
        return;
    } else {
        draw_a(order-1);
        turtle_.set_heading(-90).forward(step_);
        draw_d(order-1);
        turtle_.set_heading(180).forward(step_);
        draw_d(order-1);
        turtle_.set_heading(90).forward(step_);
        draw_c(order-1);
    }
}

int main() {
    PSTurtle t = PSTurtle(200, 200);
    t.setup();
    Hilbert h(t, Point(100, 100), 200);
    h.draw(2);
    return 0;
}
