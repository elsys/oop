#include <iostream>

using namespace std;

class Point {
    double x_, y_;

    public:
    
    Point(double x, double y)
            : x_(x), y_(y) {}

    double get_x() const {
        return x_;
    }
    
    Point& set_x(double x) {
        x_ = x;
        return *this;
    }
    
    double get_y() const {
        return y_;
    }
    
    Point& set_y(double y) {
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
    
    Point minus(const Point& other) const {
        return Point(x_ - other.x_, y_ - other.y_);
    }
    
    Point operator+(const Point& other) const {
        return plus(other);
    }
    
    Point operator-() const {
        return Point(-x_, -y_);
    }
    
    Point& operator +=(const Point& other) {
        x_ += other.x_;
        y_ += other.y_;
        return *this;
    }
};

Point operator-(const Point& first, const Point& second) {
    return first.minus(second);
}

ostream& operator<<(ostream& out, const Point& point) {
    out << "Point(" << point.get_x() << ", "
                    << point.get_y() << ") ";
    return out;
}

int main () {
    Point p1(10, 10);
    Point p2(20, 20);
    Point p3 = p1 + p2;
    Point p4 = p1 - p2;
    Point p5 = -p1 - p2;
    p1 += p2;
        
    cout << p1 << endl
         << p2 << endl
         << p3 << endl
         << p4 << endl
         << p5 << endl;
    return 0;
}
