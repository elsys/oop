#include "employee.h"
#include <iostream>
using std::cout;
using std::endl;
using std::string;

employee::employee(){};
employee::employee(string name, int id)
{
    this->name = name;
    this->id = id;
}

string employee::getName() const
{
    return name;
}

int employee::getId() const
{
    return id;
}

void employee::setName(string name)
{
    this->name = name;
}

void employee::setId(int id)
{
    this->id = id;
}

void employee::print()
{
    cout << "Name: " << name << ", Id: " << id << endl;
}