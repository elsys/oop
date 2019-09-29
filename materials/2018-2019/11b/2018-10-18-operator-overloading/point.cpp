#include <iostream>

using namespace std;

class Point {
    double x_, y_;

public:

    Point(double x=0.0, double y=0.0) : x_(x), y_(y) {}

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

    void print() {
        cout << "Point(" << x_ << ", " << y_ << ")" << endl;
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

    // p1 + p2
    Point operator+(const Point& other) {
        Point result(x_, y_);
        result.add(other);
        return result;
    }

    Point& operator+=(const Point& other) {
        //this->add(other);
        add(other);
        return *this;
    }

    Point& operator-(void) {
        x_ = -x_;
        y_ = -y_;
        return *this;
    }
};

Point operator+(const Point& left, const Point& right) {
    cout << "Outside" << endl;
    Point result(left.get_x(), left.get_y());
    result.add(right);
    return result;
}

Point operator-(const Point& left, const Point& right) {
    Point result(left.get_x(), left.get_y());
    result.sub(right);
    return result;
}

ostream& operator<<(ostream& out, const Point& p) {
    out << "Point("
        << p.get_x()
        << ", " << p.get_y() << ");";
}

istream& operator>>(istream& in, Point& p) {
    char c;
    double x, y;

    in >> c;

    if (c != '(') {
        in.clear(ios_base::badbit);
        return in;
    }

    in >> x >> c;

    if (c != ',') {
        in.clear(ios_base::badbit);
        return in;
    }

    in >> y >> c;

    if (c != ')') {
        in.clear(ios_base::badbit);
        return in;
    }

    if (in.good()) {
        p.set_x(x).set_y(y);
    }

    return in;
}

int main(int argc, char const *argv[]) {

    Point p1(10.0, 10.0);
    Point p2(5.0, 5.0);
    Point p3(2.0, 2.0);

    p1.print();

    //p1.set_x(20).set_y(20).add(p2).sub(p3);

    p1 = p1 + p2;

    p1 = p1 - p3;

    p1 += p2;

    p1.print();

    Point p4(3.0, 4.0);

    p1 = -p4;

    p1.print();

    cout << endl;

    cout << p1 << p2 << p3 << p4 << endl;

    Point p5;

    cin >> p5;

    cout << p5 << endl;

    return 0;
}
