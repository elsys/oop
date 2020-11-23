#include "manager.h"
#include <iostream>
using std::cout;
using std::endl;
using std::string;

manager::manager(){};
manager::manager(string name, int id, int level) : employee(name, id)
{
    this->level = level;
}

int manager::getLevel() const
{
    return level;
}

void manager::setLevel(int level)
{
    this->level = level;
}

void manager::print() const
{
    cout << "Name: " << getName() << ", Id: " << getId() << ", Level: " << endl;
}