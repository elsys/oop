#include "triangle.hh"
#include <math.h>

float triangle::perimeter() const
{
    return getDistance(a, b) + getDistance(b, c) + getDistance(c, a);
}

float triangle::area() const
{
    float halfPerimeter = perimeter() / 2;

    return sqrt((halfPerimeter - getDistance(a, b)) * (halfPerimeter - getDistance(b, c)) * (halfPerimeter - getDistance(c, a)));
}