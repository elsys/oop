#include <iostream>

using namespace std;

class Point {
    double x_, y_;
public:
    Point(double x=0.0, double y=0.0): x_(x), y_(y) {}

    double get_x() const {
        return x_;
    }

    double get_y() const {
        return y_;
    }

    Point& set_x(double x) {
        x_ = x;
        return *this;
    }

    Point& set_y(double y) {
        y_ = y;
        return *this;
    }

    Point& add(const Point& other) {
        x_ += other.x_;
        y_ += other.y_;
        return *this;
    }

    Point& sub(const Point& other) {
        x_ -= other.x_;
        y_ -= other.y_;
        return *this;
    }

    Point& mul(double a) {
        x_ *= a;
        y_ *= a;
        return *this;
    }

    Point operator+(const Point& other) const {
        Point result(x_, y_);
        result.add(other);
        return result;
    }

    Point& operator++(void) {
        x_++;
        y_++;
        return *this;
    }

    Point operator++(int) {
        Point result(x_, y_);
        x_++;
        y_++;
        return result;
    }

    Point& operator+=(const Point& other) {
        add(other);
        return *this;
    }
};

Point operator-(const Point& p1, const Point& p2) {
    Point result(p1.get_x(), p1.get_y());
    result.sub(p2);
    return result;
}

ostream& operator<<(ostream& out, const Point& p) {
    out << "Point(" << p.get_x() << ", " << p.get_y() << ");";
    return out;
}

istream& operator>>(istream& in, const Point& p) {
    //Input format: "(x,y)"
    double x, y;
    char c;
    in >> c;
    if(c != '(') {
        in.clear(ios_base::badbit);
    }
    in >> x >> c;
    if(c != ',') {
        in.clear(ios_base::badbit);
    }
    in >> y >> c;
    if(c != ')') {
        in.clear(ios_base::badbit);
    }
    p.set_x(x);
    p.set_y(y);
    return in;
}

int main() {
    Point p1(10.0, 8.0);
    Point p2(3.0, 5.0);

    p1 += p2;
    cout << p1 << ", " << p2 << endl;

    Point p3 = p1 - p2;
    cout << "Point(" << p3.get_x() << ", " << p3.get_y() << ")" << endl;

    return 0;
}
