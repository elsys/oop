#include <iostream>

using namespace std;

class Point
{
    int id;
    int x;
    int y;

public:
    static int counter;

    //Non static members can access non static members and static members
    Point() : x(0), y(0)
    {
        id = counter++;
        // create();
    }

    Point(int x, int y) : x(x), y(y)
    {
        id = counter++;
    }

    int get_x() const
    {
        return x;
    }

    int get_y() const
    {
        return y;
    }

    int get_id() const
    {
        return id;
    }
    //static methods can access only static members
    static Point create()
    {
        counter = 5;
        // get_x();
        // x = 4;
        return Point();
    }
};

class Shape
{
private:
    Point*points = nullptr; //NULL == 0

public:
    Shape(int x)
    {
        points = new Point[x];
    }

    //destructor - destroys the object
    ~Shape()
    {
        cout << "Destructor called" << endl;
        delete[] points;
    }
};

void test()
{
    int i = 0;
    cout << i++ << endl;
}

void test2()
{
    static int i = 0;
    cout << i++ << endl;
}

int Point::counter = 0;

void test3()
{
    int i = 2;
    int *a = new int;
}

void test4()
{
    Shape s(4); //will be deleted at function end
    Shape *s = new Shape(3); //wont be deleted at function end
}

Point &test5()
{
    // Point p(2, 3);
    //return p // can't be returned because will be delted at function end
    Point *p = new Point(2, 3);
    // delete p;
    return *p;
}

int main()
{
    // test();
    // test();

    // test2();
    // test2();
    // test2();
    // cout << Point::counter << endl;
    // Point p1 = Point();
    // Point p2 = Point();
    // Point p3 = Point();
    // cout << "p1: " << p1.get_id() << endl;
    // cout << "p2: " << p2.get_id() << endl;
    // cout << "p3: " << p3.get_id() << endl;
    // cout << Point::counter << endl;
    // Point p4 = Point::create();
    // cout << "p4: " << p4.get_id() << endl;

    int a = 3;

    int *i = new int;
    Point *p = new Point(2, 3);
    int *i2 = new int[3];
    Point *p2 = new Point[4];

    delete i;
    delete p;
    delete[] i2; // same for multiple dimenssion arrays
    delete[] p2;

    Shape *s = new Shape(3);
    delete s;
    test4();

    Point &p3 = test5();
    cout << p3.get_id() << endl;
    delete &p3;
}