#include <iostream>

using namespace std;

#include "Test1.hh"
#include "Test2.hh"
#include "Test3.hh"

void foo(const Test1 &arg) {
    cout << "friend function: " << arg.v << endl;
}

void Test2::bar(const Test1 &arg) {
    cout << "friend class: " << arg.v << endl;
}

void Test3::baz(const Test1 &arg) {
    cout << "friend class method: " << arg.v << endl;
}

/*
class ostream {
public:
    // The ostream class cannot define operator overloads for our types
    // because it doesn't know about them
    ostream& operator<<(<unknown right side argument type> arg) {
        // print stuff in the console
    }
};*/

// Overloaded operators don't have to be class members
// and this works just like normal functions (foo, foo2)
ostream& operator<<(ostream &out, const Test1 &arg) {
    // Either define a getter or declare the operator as friend to allow access
    out << arg.v << endl;
}

int main()
{
    Test1 t1;
    Test2 t2;
    Test3 t3;

    // friend function
    foo(t1);
    // friend class
    t2.bar(t1);
    // friend method in class
    t3.baz(t1);
    // friend function but inline
    foo2(t1);

    cout << t1;

    return 0;
}
