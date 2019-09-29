#include <iostream>

using namespace std;

class Point {
    double x_, y_;
    const double begin_x_, begin_y_;

    public:
    
    Point(double x, double y)
            : begin_x_(0), begin_y_(0), x_(x), y_(y) {}
    
    Point(double begin_x, double begin_y,
            double x, double y)
            : begin_x_(begin_x), begin_y_(begin_y),
              x_(x), y_(y) {}
    
    double get_x() const {
        return x_;
    }
    
    Point& set_x(double x) {
        x_ = x;
        return *this;
    }
    
    double get_y() const {
        // pointless usage of this
        return this -> y_;
    }
    
    Point& set_y(double y) {
        // pointless usage of this
        (*this).y_ = y;
        // meaningful usage of this
        return *this;
    }
    
    void print() const {
        cout << "Point(" << x_ << ", "
                         << y_ << ")" << endl;
    }
    
    void print_absolute() const {
        Point(x_ + begin_x_, y_ + begin_y_).print();
    }

};

int main() {
    const Point p1(10, 10);
    p1.print();
    
    Point p2(11, 12);
    p2.set_x(20);
    p2.print();
    
    Point p3(0, 0);
    p3.set_y(10).set_x(11).print();
    
    Point p4(10, 10, 1, 1);
    p4.print();
    p4.print_absolute();
    return 0;
}








