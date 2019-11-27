#ifndef MANAGER_H
#define MANAGER_H
#include "employee.h"
#include <string>

class Manager : public Employee {
	int level;
	public:
		Manager();
		Manager(std::string name, int id, int level);
		
		void setLevel(int level);
		int getLevel() const;
};
#endif
