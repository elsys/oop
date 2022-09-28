#ifndef _EMPLOYEE_HH_
#define _EMPLOYEE_HH_

#include <string>
using std::string;
class employee
{
private:
    int id;
    string name;

public:
    employee();
    // employee(int id, string name) : id(id), name(name){};
    employee(const int &id, const string &name);
    int getId() const;
    string getName() const;
    void setId(const int &id);
    void setName(const string &name);
    virtual void print() const;
};

#endif