#include <iostream>
using namespace std;

class A
{
    int a = 1;

public:
    int b = 2;
    int getA() const
    {
        return a;
    }

protected:
    int c = 3;
};

class B : private A
{
    int d = 4;

public:
    int getE() { return getA(); }
    void changeC() { c = 5; }
    void changeB() { b = 6; }
    int getC() { return c; }
};

int main()
{
    A a;
    B b;

    //cout << a.a << endl;
    cout << a.b << endl;
    cout << a.getA() << endl;
    //cout << a.c << endl;
    //cout << b.d << endl;
    cout << b.getE() << endl;
    b.changeC();
    cout << b.getC() << endl;
    //cout << b.b << endl;
}