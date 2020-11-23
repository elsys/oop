#include "manager.h"
#include <iostream>
manager::manager() {}
manager::manager(std::string name, int id, int level) : employee(name, id)
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
    std::cout << "Name: " << getName() << ", Id: " << getId() << ", Level: " << level << std::endl;
}