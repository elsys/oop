#include <iostream>

using namespace std;

class Point {
    int x_, y_;
    
    // the begininig of the coordinate system
    const int begin_x_, begin_y_;
    
    public:
    
    Point(int begin_x, int begin_y, int x, int y)
        : begin_x_(begin_x), begin_y_(begin_y), x_(x), y_(y)  {}
    
    Point(int x, int y)
        : begin_x_(0), begin_y_(0), x_(x), y_(y) {}
    
    int get_x() const {
        return x_;
    }
    
    Point& set_x(int x) {
        x_ = x;
        return *this;
    }
    
    int get_y() const {
        return (*this).y_;
    }
    
    Point& set_y(int y) {
        // accessing members through this
        this->y_ = y;
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

    Point p1(0, 0);
    p1.set_x(10).set_y(11).print();

    const Point p2(11, 11);
    p2.print();
    p2.get_x();
    
    Point p3(10, 10, 32, 32);
    p3.print_absolute();
    return 0;
}
