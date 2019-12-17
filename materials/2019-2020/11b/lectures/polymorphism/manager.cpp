#include "manager.h"
#include <iostream>

Manager::Manager(std::string name, long id, int level) : Employee(name, id) {
	this -> level = level;
}

void Manager::print() const {
	Employee::print();
	std::cout << "\tlevel: " << level << std::endl;
}
