#include "manager.hh"
#include <iostream>

using namespace std;
manager::manager()
{
    setId(0);
    setName("");
    level = 0;
}

int manager::getLevel() const
{
    return level;
}

void manager::setLevel(int level)
{
    this->level = level;
}

void manager::print() const {
    cout << "Manger(" << getId() << ", " << getName() 
    << ", " << level << ")" << endl;
}