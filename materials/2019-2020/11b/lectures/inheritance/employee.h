#ifndef EMPLOYEE_H
#define EMPLOYEE_H
#include <string>

class Employee {
	std::string name;
	int id;
	public:
		Employee();
		Employee(std::string name, int id);
		
		void setName(std::string name);
		std::string getName() const;
		
		void setId(int id);
		int getId() const;
		
		void print() const;
};
#endif
