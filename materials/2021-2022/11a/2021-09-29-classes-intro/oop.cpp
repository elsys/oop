#include <iostream>
#include <cmath>
using namespace std;

void add(int &v)
{
    v++;
}

struct Point2
{
    //default public
    int x;
    int y;
};

class Point
{
    //default private
private:
    int x;
    int y;

public:
    Point(int x, int y)
    {
        this->x = x;
        this->y = y;
    }
    Point()
    {
    }
    void set_x(int x)
    {
        this->x = x;
    }

    void set_y(int y)
    {
        this->y = y;
    }

    int get_x()
    {
        return this->x;
    }

    int get_y()
    {
        return this->y;
    }

    double distance(Point p)
    {
        int dx = p.get_x() - this->get_x();
        int dy = p.y - y;
        return sqrt(dx * dx + dy * dy);
    }
};

int main()
{
    Point p(0, 0);
    // p.set_x(2);
    // p.set_y(3);
    cout << p.get_x() << endl;
    cout << p.get_y() << endl;

    Point p2(4, 3);
    cout << "Distance: " << p.distance(p2) << endl;

    int a = 5;
    int q;
    char c = 'c';
    long l = 123;
    double d = 12.22;
    unsigned int ui = 5;
    bool b = true;
    short s;
    int array[] = {1, 2, 3, 4};
    int arr[5];
    // int *p;
    // p = &a;

    auto m = {1, 2, 3};

    // cout << *p << endl;

    int &r = a;
    r = 10;
    cout << a << endl;

    add(a);
    cout << a << endl;

    cout << "Hello World" << endl;
}