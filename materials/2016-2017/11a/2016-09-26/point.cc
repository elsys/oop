#include <iostream>
#include <cmath>

using namespace std;

class MyPoint;

double distance_between(MyPoint p1, MyPoint p2);

/**
    private
    public
    protected
*/
class MyPoint {
    float x_, y_;
    
    public:

    MyPoint() {
        x_ = 0;
        y_ = 0;
    }
    
    MyPoint(float x, float y) {
        x_ = x;
        y_ = y;
    }
         
    float get_x() {
        return x_;
    }
    
    void set_x(float x) {
        x_ = x;
    }
    
    float get_y() {
        return y_;
    }
    
    void set_y(float y) {
        y_ = y;
    }
    
    void print() {
        cout << "MyPoint(" << x_ << ", " << y_
            << ")" << endl;
    }
    
    MyPoint add(MyPoint other) {
        return MyPoint(x_ + other.x_, y_ + other.y_);
    }
    
    void add_current(MyPoint other) {
        x_ += other.x_;
        y_ += other.y_;
    }
    
    double distance_to(MyPoint other) {
        return distance_between(*this, other);
    }
};

double distance_between(MyPoint p1, MyPoint p2) {
    return sqrt(pow(p1.get_x() - p2.get_x(), 2)
            + (p1.get_y() - p2.get_y(), 2));
}

int main() {
    MyPoint p1(5, 6);
    MyPoint p2(10, 10);
    
    MyPoint p3 = p1.add(p2);
    
    p1.print();
    p2.print();
    p3.print();
    
    cout << "Adding to current point..." << endl;
    p1.add_current(p2);
    p1.print();
  
    
    cout << "Distance between p1 and p2: "
         << p1.distance_to(p2) << endl;
}






