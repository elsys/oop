#include <iostream>
#include "employee.hh"
#include "manager.hh"
using namespace std;

void print(const employee &e)
{
    e.print();
}

int main()
{
    employee e(1, "employee");
    manager m(1, "manager", 2);
    print(e);
    print(m);
}