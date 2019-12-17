#ifndef _MANAGER_H_
#define _MANAGER_H_

#include "employee.h"
#include <string>

class Manager : public Employee {
	int level;
	public:
		Manager(std::string name, long id, int level);
		
		void print() const;
};

#endif
