#include "employee.hh"

#include <iostream>
using namespace std;

employee::employee()
{
    id = 0;
    name = "";
}

employee::employee(const int &id, const string &name)
{
    this->id = id;
    this->name = name;
}

int employee::getId() const {
    return id;
}

string employee::getName() const {
    return name;
}

void employee::setId(const int & id) {
    this -> id = id;
}

void employee::setName(const string & name) {
    this -> name = name;
}

void employee::print() const {
    cout << "Employee(" << id << ", " << name << ")" << endl;
}