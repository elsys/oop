#include <iostream>

using namespace std;

struct Point {
    
    private:
    
    float x_, y_;
    
    public:
    
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
    Point p = {5, 6};
    cout << p.get_x() << endl;
    cout << p.get_y() << endl;
    p.print();
    p.set_x(10);
    p.set_y(42);
    p.print();
    Point p1 = {11, 22};
    p1.print();
}



