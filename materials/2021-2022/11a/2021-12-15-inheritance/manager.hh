#ifndef _MANAGER_HH_
#define _MANAGER_HH_

#include "employee.hh"

/*
inheritance types:
public - public are staying public
         protected are staying protected
private - public are becoming private
          protected are becoming private
protected - public are becoming protected
            protected are staying protected
*/
class manager : public employee
{
    int level;

public:
    manager();
    manager(int id, string name, int level) : employee(id, name), level(level) {}

    int get_level() const;

    void set_level(int level);
};

#endif