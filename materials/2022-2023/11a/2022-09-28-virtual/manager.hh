#ifndef _MANAGER_HH_
#define _MANAGER_HH_
#include "employee.hh"

class manager : public employee
{
private:
    int level;

public:
    manager();
    manager(const int &id, const string &name, const int &level)
        : employee(id, name), level(level){}
    int getLevel() const;
    void setLevel(int level);
    void print() const;
};

#endif