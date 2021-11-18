#include <iostream>

using namespace std;
/*
cannot overload
::
.*
?:
can be overloaded:
unary:
- ++ -- !
binary:
+ - * / % += -+ *= < > <= >=
*/

class Point
{
    double x;
    double y;

public:
    Point(double x, double y)
    {
        this->x = x;
        this->y = y;
    }

    Point() : Point(0, 0) {}

    double get_x() const
    {
        return x;
    }

    double get_y() const
    {
        return y;
    }

    void set_x(double x)
    {
        this->x = x;
    }

    void set_y(double y)
    {
        this->y = y;
    }

    Point add(const Point &p)
    {
        return Point(x + p.x, y + p.y);
    }

    Point sub(const Point &p)
    {
        return Point(x - p.x, y - p.y);
    }

    Point mul(double alpha)
    {
        return Point(x * alpha, y * alpha);
    }

    Point operator+(const Point &p)
    {
        return Point(x + p.x, y + p.y);
    }

    Point operator-()
    {
        return Point(-x, -y);
    }

    Point &operator+=(const Point &p)
    {
        x += p.x;
        y += p.y;
        return *this;
    }

    Point operator*(double alpha)
    {
        return Point(x * alpha, y * alpha);
    }

    Point &operator++(int)
    {
        x++;
        y++;
        return *this;
    }

    Point &operator++()
    {
        x++;
        y++;
        return *this;
    }

    double operator[](int index) const
    {
        if (index < 0 || index > 1)
        {
            throw invalid_argument("Index must be 0 or 1");
        }

        if (index == 0)
        {
            return x;
        }
        else
        {
            return y;
        }
    }

    bool operator==(const Point &p) const
    {
        if (x == p.x && y == p.y)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
};

// Point &opertor=(Point &p)
// {
//     return Point(1, 2);
// }

Point operator-(const Point &p1, const Point &p2)
{
    return Point(p1.get_x() - p2.get_x(), p1.get_y() - p2.get_y());
}

ostream &operator<<(ostream &out, const Point &p)
{
    out << "Point(" << p.get_x() << ", " << p.get_y() << ")" << endl;
    return out;
}

Point &operator--(Point &p)
{
    p.set_x(p.get_x() - 1);
    p.set_y(p.get_y() - 1);
    return p;
}

Point &operator--(Point &p, int)
{
    p.set_x(p.get_x() - 1);
    p.set_y(p.get_y() - 1);
    return p;
}

void print_point(const Point &p)
{
    cout << "Point(" << p.get_x() << ", " << p.get_y() << ")" << endl;
}

int main()
{
    // Point p1(1, 2);
    // Point p2(2, 3);
    // // Point p3 = p1.add(p2);
    // Point p3 = p1 + p2;
    // print_point(p1);
    // print_point(p2);
    // print_point(p3);
    // // Point p4 = p3.sub(p2);
    // Point p4 = p3 - p2;
    // Point p5 = p2.mul(2);
    // print_point(-p4);
    // print_point(p5);

    Point p1(1, 1);
    Point p2(2, 2);
    p1 += p2;
    // print_point(p1);
    cout << p1;
    Point p3 = p1 * 2;
    // print_point(p3);
    cout << p3;
    Point p4 = p3++;
    cout << p4;
    Point p5 = ++p3;
    cout << p5;
    p3--;
    --p3;
    cout << p3;
    Point p6(3, 4);
    cout << p6[0] << endl;
    cout << p6[1] << endl;
    // cout << p6[3] << endl;
    const Point &p7 = p6;
    p7[1];
    Point p8(3, 4);
    bool eq = p6 == p8;
    cout << eq;
}