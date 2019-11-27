#include "employee.h"
#include "manager.h"
#include <string>
using std::string;

Manager::Manager() {
	level = 0;
}

Manager::Manager(string name, int id, int level) : Employee(name, id) {
	this -> level = level;
}

void Manager::setLevel(int level) {
	this -> level = level;
}

int Manager::getLevel() const {
	return level;
}
