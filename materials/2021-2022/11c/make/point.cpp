#include "Point.h"
#include <iostream>

Point::Point()
{
	//you can do either 
	//set(0, 0);
	this->x = 0;
	this->y = 0;
}
Point::Point(int x, int y)
{
	//you can do either 
	//set(x0, y0);
	this->x = x;
	this->y = y;
}

void Point::set(int x, int y)
{
	this->x = x;
	this->y = y;
}

int Point::getx() { return this->x; }
int Point::gety() { return this->y; }

void Point::move(int dx, int dy)
{
	this->x += dx;
	this->y += dy;
}

void Point::print()
{
	std::cout << "(" << this->x << ", " << this->y << ")";
}
