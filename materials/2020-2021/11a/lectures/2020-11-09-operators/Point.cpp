#include <iostream>
using namespace std;

class Point {
    int x;
    int y;
public:
    Point (int x, int y) {
        this -> x = x;
        this -> y = y;
    }

    int getX() const {
        return x;
    }

    int getY() const {
        return y;
    }

    void setX(int x) {
        this -> x = x;
    }

    void setY(int y) {
        this -> y = y;
    }

    Point& add(const Point& p) {
        this -> x += p.x;
        this -> y += p.y;
        return *this;
    }

    Point& sub(const Point& p) {
        this -> x -= p.x;
        this -> y -= p.y;
        return *this;
    }

    Point& mul(int value) {
        this -> x *= value;
        this -> y *= value;
        return *this;
    }

    Point operator+(const Point& p) {
        Point result = Point(this -> x + p.x, this -> y + p.y);
        return result;
    }

/*
    Point operator-(const Point& p) {
        Point result = Point(this -> x - p.x, this -> y - p.y);
        return result;
    }
*/
    Point operator-() {
        Point result = Point(-x, -y);
        return result;
    }

    Point operator*(const Point& point) {
        Point result = Point(this -> x * point.x, this -> y * point.y);
        return result;
    }

    Point operator*(const int value) {
        Point result = Point(this -> x * value, this -> y * value);
        return result;
    }

    Point& operator++() {
        ++x;
        ++y;
        return *this;
    }

    Point& operator++(int) {
        x++;
        y++;
        return *this;
    }
};

ostream& operator<<(ostream& out, Point point) {
    out << "point(" << point.getX() << ", " << point.getY() << ")" << endl;
    return out;
}

Point operator-(const Point& p1, const Point& p2) {
    Point result = Point(p1.getX() - p2.getX(), p1.getY() - p2.getY());
    return result;
}

int main() {
    Point p1 = Point(1, 2);
    Point p2 = Point(2, 3);

    //p1.add(p2).mul(2);

    Point p3 = p1 + p2;

    cout << "point(" << p3.getX() << ", " << p3.getY() << ")" << endl;

    Point p4 = p1 - p2;

    cout << "p4: " << p4;

    Point p5 = -p1;

    cout << "point(" << p5.getX() << ", " << p5.getY() << ")" << endl;

    Point p6 = p1 * p2;

    cout << "point(" << p6.getX() << ", " << p6.getY() << ")" << endl;

    Point p7 = p1 * 3;

    cout << "point(" << p7.getX() << ", " << p7.getY() << ")" << endl;

    Point p8 = p1++;

    cout << "point(" << p8.getX() << ", " << p8.getY() << ")" << endl;

    Point p9 = ++p1;

    cout << "p9: " <<p9;

    return 0;
}