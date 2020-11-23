#ifndef MANAGER_H
#define MANAGER_H
#include "employee.h"
class manager : public employee
{
    int level;

public:
    manager();
    manager(std::string name, int id, int level);

    int getLevel() const;

    void setLevel(int level);

    void print() const;
};

#endif