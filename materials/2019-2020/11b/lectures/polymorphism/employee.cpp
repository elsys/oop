#include "employee.h"
#include <iostream>

Employee::Employee(std::string name, long id) {
	this -> name = name;
	this -> id = id;
}

void Employee::print() const {
	std::cout << name << " " << id << std::endl;
}
