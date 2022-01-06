#include "manager.hh"
#include <iostream>
using namespace std;
manager::manager() {
  set_id(0);
  set_name("");
  level = 0;
}

int manager::get_level() const { return level; }

void manager::set_level(int level) { this->level = level; }

void manager::print() const {
    cout << "Id: " << get_id() << ", Name: " << get_name()  << " Level:" << level << endl;
}