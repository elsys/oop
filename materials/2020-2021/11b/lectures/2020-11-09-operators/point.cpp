#include <iostream>
using namespace std;

class Point {
    int x;
    int y;
    public:
    Point(int x, int y) {
        this -> x = x;
        this -> y = y;
    }

    void setX(int x) {
        this -> x = x;
    }

    void setY(int y) {
        this -> y = y;
    }

    int getX() const {
        return x;
    }

    int getY() const {
        return y;
    }

    Point& add(const Point& p) {
        x += p.x;
        y += p.y;
        return *this;
    }

    Point& sub(const Point& p) {
        x -= p.x;
        y -= p.y;
        return *this;
    }

    Point& mul(const int value) {
        x *= value;
        y *= value;
        return *this;
    }

    Point operator+ (const Point& p) {
        Point result = Point(x + p.x, y + p.y);
        return result;
    }
/*
    Point operator- (const Point& p) {
        Point result = Point(x - p.x, y - p.y);
        return result;
    }
*/
    Point operator- () {
        Point result = Point(-x, -y);
        return result;
    }

    Point operator* (const int value) {
        Point result = Point(x * value, y * value);
        return result;
    }

    Point& operator++ () {
        ++x;
        ++y;
        return * this;
    }

    Point& operator++ (int) {
        x++;
        y++;
        return *this;
    }
};

Point operator- (const Point& p1, const Point& p2) {
    Point result = Point(p1.getX() - p2.getX(), p1.getY() - p2.getY());
    return result;
}

ostream& operator<< (ostream& out, const Point& p) {
    out << "point(" << p.getX() << ", " << p.getY() << ")";
    return out;
}

void print(const Point& p) {
    cout << p << endl;
}

int main() {
    Point p1 = Point(2, 3);
    Point p2 = Point(3, 4);

    p1.add(p2).mul(2);
    print(p1);

    Point p3 = p1 + p2;
    print(p3);
    Point p4 = p1.operator+(p2);
    print(p4);
    Point p5 = p1 - p2;
    //Point p5 = operator-(p1, p2);
    print(p5);
    Point p6 = -p1;
    print(p6);
    Point p7 = p1 * 2;
    print(p7);
    Point p8 = p1++;
    print(p8);
    Point p9 = ++p1;
    print(p9);
}

