#include <iostream>

using namespace std;

class Figure {
public:
    virtual void draw() const = 0;
};

class FourPointsFigure: public Figure {

};

class Circle: public Figure {
public:

    void draw() const {
        cout << "O" << endl;
    }
};

int main() {
//    Figure f1; not possible!
//    FourPointsFigure f2; not possible!
    Circle c1;
    c1.draw();
    return 0;
}
