#include <iostream>
#include <string>

using namespace std;

class Point
{
    const string _name;
    int x;
    int y;

public:
    Point(const string name, int x, int y) : _name(name), x(x) //, y(y)
    {
        // this->name = name;
        // this->x = x;
        this->y = y;
    }

    // Point() : _name("Default")
    // {
    //     this->x = 0;
    //     this->y = 0;
    // }

    Point() : Point("Default", 1, 2) {}

    void set_x(int x)
    {
        this->x = x;
    }

    void set_y(int y)
    {
        this->y = y;
    }

    int get_x() const
    {
        return x;
    }

    int get_y() const
    {
        return y;
    }

    string get_name() const
    {
        return _name;
    }
};

void print_point(const Point &p)
{
    // p.set_x(7);
    cout << p.get_name() << ": " << p.get_x() << ", " << p.get_y() << endl;
}

void add_one(Point &p)
{
    p.set_x(p.get_x() + 1);
    p.set_y(p.get_y() + 1);
    // p = 3;
}

int main()
{
    // const int a = 5;
    // // a = 6;
    // int b = 4;

    // const int &aa = a;
    // int c = 5;
    // const int &cc = c;
    // c = 7;
    // // cc = 5;
    // int &bb = b;
    // bb = c;
    // bb++;
    // cout << "b: " << b << "c: " << c << endl;
    Point p = Point("Point 1", 2, 3);
    print_point(p);
    Point p2 = Point("Point 2", 3, 4);
    print_point(p2);
    Point p3 = Point();
    print_point(p3);
    add_one(p3);
    print_point(p3);
    const Point &pp = p3;
    print_point(pp);
    // add_one(pp);
    Point &ppp = p3;
    print_point(ppp);
    add_one(ppp);
    print_point(ppp);

    // int a = 4;
    // const int *aa = &a;
    // int b = 6;
    // aa = &b;
    // *aa = 5; Not possible
    // cout << "a: " << a << " b: " << b << " aa:" << aa << endl;
}