#ifndef POINT_HH_
#define POINT_HH_

class Point {
    double x_, y_;

public:
    Point(double x, double y);
    double get_x() const;
    double get_y() const;
    Point& set_x(double x);
    Point& set_y(double y);
    void print() const;
};

#endif
