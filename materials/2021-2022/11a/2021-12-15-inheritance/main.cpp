#include "employee.hh"
#include "manager.hh"

#include <vector>
#include <iostream>

void print(const employee &e)
{
    cout << "Id: " << e.get_id() << ", Name: " << e.get_name() << endl;
}

void print(const manager &m)
{
    cout << "Id: " << m.get_id() << ", Name: " << m.get_name() << ", Level: " << m.get_level() << endl;
}

// overloading - different type parameters or different amount or different order
// void test(int a, double b) {}

// void test(double b, int a) {

// }

int main()
{
    employee e = employee(1, "Employee 1");
    manager m = manager(2, "Manager 1", 1);

    vector<employee> v;

    v.push_back(e);
    v.push_back(m);

    vector<manager> v2;

    v2.push_back(m);
    // v2.push_back(e);

    print(e);
    print(m);
}