#include <iostream>
#include <cmath>
#include <vector>

using namespace std;

class Point {
    double x_, y_;

public:
    Point(double x=0.0, double y=0.0)
        : x_(x), y_(y) {}

    double get_x() const {
        return x_;
    }

    double get_y() const {
        return y_;
    }

    bool isUpper(const Point& other) const {
        return y_ < other.y_;
    }

    bool isLefter(const Point& other) const {
        return x_ < other.x_;
    }

};

class Shape {

public:
    virtual double perimeter() const = 0;
};

class Circle : public Shape {
    double radius_;
    Point center_;

public:
    Circle(double radius, const Point& center)
        : radius_(radius), center_(center)
        {}

    double perimeter() const {
        return 2 * M_PIl * radius_;
    }
};

// 1. Дефинирайте функцията draw()
// 2. Създавате клас Triangle
// 3. Дефинирайте функцията area()

class ShapeException {};

class Rectangle : public Shape {
    Point upperLeft_, bottomRight_;

public:
    Rectangle(const Point& upperLeft, const Point& bottomRight)
        : upperLeft_(upperLeft), bottomRight_(bottomRight){
        if(!upperLeft_.isUpper(bottomRight_)
        || !upperLeft_.isLefter(bottomRight_))
        {
            throw ShapeException();
        }
    }

    double perimeter() const {
        return 2 * (bottomRight_.get_x() - upperLeft_.get_x())
                + 2 * (bottomRight_.get_y() - upperLeft_.get_y());
    }
};

int main() {
    Circle c1(3.0, Point(4.0, 5.0));
    vector<Shape*> shapes;
    shapes.push_back(&c1);
    try {
        shapes.push_back(new Rectangle(Point(1.0, 1.0), Point(3.0, 4.0)));
    } catch (ShapeException se) {
        cout << "Could not initialize rectangle" << endl;
    }

    for(vector<Shape*>::iterator it = shapes.begin();
            it != shapes.end(); it++) {
        cout << (*it) -> perimeter() << endl;

    }

    return 0;
}
