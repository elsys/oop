#include <iostream>
using namespace std;

class Point
{
    int x;
    int y;

public:
    Point(int x, int y)
    {
        this->x = x;
        this->y = y;
    }

    Point(const Point &p)
    {
        x = p.x;
        y = p.y;
    }

    Point &operator=(const Point &p)
    {
        x = p.x;
        y = p.y;
    }

    int getX() const { return x; }
    int getY() const { return y; }
    void setX(int x) { this->x = x; }
    void setY(int y) { this->y = y; }
};

int main()
{
    Point p1 = Point(2, 3);
    Point p2 = Point(p1);
    Point p3 = p2;
}