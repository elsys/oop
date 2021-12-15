#include "employee.hh"

#include <string>
#include <iostream>

employee::employee()
{
    id = 0;
    name = "";
}

employee::employee(int id, string name)
{
    this->id = id;
    this->name = name;
}

int employee::get_id() const
{
    return id;
}

string employee::get_name() const
{
    return name;
}

void employee::set_id(int id)
{
    this->id = id;
}

void employee::set_name(string name)
{
    this->name = name;
}

void employee::print() const {
    cout << "Id: " << id << ", Name: " << name << endl;
}