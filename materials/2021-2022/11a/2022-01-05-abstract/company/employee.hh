#ifndef _EMPLOYEE_HH_
#define _EMPLOYEE_HH_

#include <string>
using namespace std;

class employee {
  int id;
  string name;

protected: // visible for all sub classes, hidden from outer world
  int protected_field;

public:
  int public_field;
  employee();
  employee(int id, string name);
  int get_id() const;
  string get_name() const;

  void set_id(int id);
  void set_name(string name);

  virtual void print() const;
};

#endif