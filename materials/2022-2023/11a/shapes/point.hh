#ifndef _POINT_HH_
#define _POINT_HH_

class point
{
private:
    int x;
    int y;
public:
    point();
    point(const int &x, const int &y)
    : x(x), y(y) {};

    int getX() const;
    void setX(const int &x);

    int getY() const;
    void setY(const int &y);
};

#endif