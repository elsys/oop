#include <iostream>
#include <string>

using namespace std;

class MyClass {
protected:
    int var1 = 10;
    string var2 = "test";

public:
    MyClass() {}
    MyClass(int var1) : var1(var1) {
        // this->var1 = var1;
    }

    void print() {
        print(cout);
    }

    void print(ostream& out) {
        out << var1 << " " << var2 << endl;
    }
};

class MyOtherClass {
protected:
    int var3 = 20;
    int var1 = 50;
};

class MyClass2 : public MyClass, public MyOtherClass {
public:
    MyClass2(int var1) 
        : MyClass(var1), MyOtherClass() {

        }

    void print() {
        print(cout);
    }

    void print(ostream& out) {
        out << MyClass::var1 << var2 << var3 << MyOtherClass::var1 << endl;
    }
};

int main() {
    // std::cout << "Hello world" << std::endl;
    cout << "Hello world" << endl;

    int var2;
    MyClass obj1;
    MyClass obj2 = MyClass();
    MyClass obj3 = MyClass(5);

    obj1.print();
    (&obj1)->print();
    obj2.print();
    obj3.print();

    MyClass2 obj4 = MyClass2(15);
    obj4.print();

    MyClass2* obj5 = new MyClass2(3);
    obj5->print();

    // delete obj5;

    return 0;
}   