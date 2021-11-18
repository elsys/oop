#pragma once

#include <iostream>

using namespace std;

#include "Test3.hh"

class Test1 {
private:
    // The private member friends will be able to access
    int v = 5;

    // foo is a normal function and not a member of Test1. It can be defined elsewhere
    // and will have private access to Test1
    friend void foo(const Test1 &);
    // Test2 will be defined somewhere outside of Test1
    // and will have private access to Test1
    friend class Test2;
    // Test3 will be defined somewhere outside of Test1
    // and ONLY the baz method will have private access to Test1
    friend void Test3::baz(const Test1 &);

    // foo2 is also a normal function and not a member of Test1
    // but is defined inline
    friend void foo2(const Test1 &arg) {
        cout << "inline friend function: " << arg.v << endl;
    }

    // Give private access to this overload
    friend ostream& operator<<(ostream& out, const Test1 &arg);
};
