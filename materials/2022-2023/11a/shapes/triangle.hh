#ifndef _TRIANGLE_HH_
#define _TRIANGLE_HH_

#include "shape.hh"

class triangle : public shape
{
private:
    point a;
    point b;
    point c;
public:
    triangle(const point &a, const point &b, const point &c)
    : a(a), b(b), c(c) {}

    float area() const;
    float perimeter() const;
};

#endif