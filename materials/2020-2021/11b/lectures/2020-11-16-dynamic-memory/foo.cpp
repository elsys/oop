#include <iostream>
#include <fstream>
using namespace std;

class Foo
{
    int bar;
    int *arr;
    ofstream st;

public:
    Foo() { bar = 0; }
    Foo(int x, int y) { bar = x + y; }
    Foo(int size) { arr = new int[size]; }
    Foo(string fileName) { st.open(fileName); }

    ~Foo()
    {
        delete[] arr;
        st.close();
    }

    int getBar() const { return bar; }
};

int main()
{
    Foo *f1 = new Foo();
    Foo *f2 = new Foo(2, 3);
    Foo *f3 = new Foo[3];
    Foo *f4 = new Foo(100);

    cout << f1->getBar() << endl;
    cout << f2->getBar() << endl;
    cout << f3->getBar() << endl;

    delete f1;
    delete f2;
    delete[] f3;
    delete f4;

    return 0;
}