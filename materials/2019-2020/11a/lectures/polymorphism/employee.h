#ifndef _EMPLOYEE_H_
#define _EMPLOYEE_H_

#include <iostream>
#include <string>

class Employee {
	std::string name;
	long id;
	public:
		Employee(std::string name, long id);
		
		virtual void print() const;
};

#endif
