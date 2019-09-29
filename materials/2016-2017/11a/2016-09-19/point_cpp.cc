#include <iostream>

using namespace std;

/**
    private
    public
    protected
*/
class Point {
    float x_, y_;
    
    public:

    Point() {
        x_ = 0;
        y_ = 0;
    }
    
    Point(float x, float y) {
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
        cout << "Point(" << x_ << ", " << y_
            << ")" << endl;
    }
};

int main() {
    Point start;
    start.print();
    
    Point p1(5, 6);
    p1.print();
}






