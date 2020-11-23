#include "employee.h"
#include "manager.h"
#include <vector>

int main()
{
    employee e = employee("Ivancho", 1);
    manager m = manager("Mariika", 2, 15);

    e.print();
    m.print();

    std::vector<employee> v;
    v.push_back(e);
    v.push_back(m);

    for (int i = 0; i < v.size(); i++)
    {
        v[i].print();
    }

    std::vector<manager> v2;
    v2.push_back(m);

    return 0;
}