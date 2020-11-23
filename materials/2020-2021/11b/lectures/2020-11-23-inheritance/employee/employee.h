#ifndef EMPLOYEE_H
#define EMPLOYEE_H
#include <string>
class employee
{
    std::string name;
    int id;

public:
    employee();
    employee(std::string name, int id);

    std::string getName() const;
    int getId() const;

    void setName(std::string name);
    void setId(int id);

    void print();
};
#endif