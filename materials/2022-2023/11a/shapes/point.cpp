#include "point.hh"

point::point()
{
    this->x = 0;
    this->y = 0;
}

int point::getX() const
{
    return this->x;
}
void point::setX(const int &x)
{
    this->x = x;
}

int point::getY() const
{
    return this->y;
}
void point::setY(const int &y)
{
    this->y = y;
}
