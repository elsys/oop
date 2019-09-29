#include <iostream>

using namespace std;

class Point {
    int x_, y_;
    
    public:
    
    Point(int x, int y)
        : x_(x), y_(y) {}
    
    int get_x() const {
        return x_;
    }
    
    Point& set_x(int x) {
        x_ = x;
        return *this;
    }
    
    int get_y() const {
        return y_;
    }
    
    Point& set_y(int y) {
        y_ = y;
        return *this;
    }

    void print() const {
        cout << "Point(" << x_ << ", "
             << y_ << ")" << endl;
    }
    
    Point plus(const Point& other) const {
        return Point(x_ + other.x_, y_ + other.y_);
    }
    
    // binary +
    Point operator+(const Point& other) const {
        return plus(other);
    }
    
    // unary -
    Point operator-() const {
        return Point(-x_, -y_);
    }
    
    // +=
    Point operator+=(const Point& other) {
        x_ += other.x_;
        y_ += other.y_;
        return *this;
    }
};

// binary -
Point operator-(const Point& first, const Point& second) {
    return first + (-second);
}

// unary +
Point operator+(const Point& point) {
    return point;
}

ostream& operator<<(ostream& out, const Point& point) {
    out << "Print(" << point.get_x() << ", "
                    << point.get_y() << ")";
    return out;
}

int main() {
    Point p1(10, 10);
    Point p2(12, 12);
    
    Point p3 = p2 + p1;
    Point p4 = p2 - p1;
    Point p5 = -p4;
    Point p6 = +p5;
    p6 += p2;
    cout << p1 << endl
         << p2 << endl
         << p3 << endl
         << p4 << endl
         << p5 << endl
         << p6 << endl;
    return 0;
}
