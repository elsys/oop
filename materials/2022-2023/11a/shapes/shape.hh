#ifndef _SHAPE_HH_
#define _SHAPE_HH_

#include "point.hh"

class shape
{
public:
    static float getDistance(const point &a, const point &b);

    virtual float area() = 0;
    virtual float perimeter() = 0;
};

#endif