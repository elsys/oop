#include "employee.h"
#include <string>
#include <iostream>
using std::string;
using std::cout;
using std::endl;

Employee::Employee() {
	name = "";
	id = 0;
}

Employee::Employee(string name, int id) {
	this -> name = name;
	this -> id = id;
}

string Employee::getName() const {
	return name;
}

void Employee::setName(string name) {
	this -> name = name;
}

int Employee::getId() const {
	return id;
}

void Employee::setId(int id) {
	this -> id = id;
}

void Employee::print() const {
	cout << "Employee: " << name << " Id: " << id << endl;
}
