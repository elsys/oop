#include "shape.hh"
#include <math.h>

float shape::getDistance(const point &a, const point &b)
{
    return sqrt((a.getX() - b.getX())^2 + (a.getY() - b.getY())^2);
}