#include "manager.hh"

manager::manager()
{
    set_id(0);
    set_name("");
    level = 0;
}

int manager::get_level() const
{
    return level;
}

void manager::set_level(int level)
{
    this->level = level;
}