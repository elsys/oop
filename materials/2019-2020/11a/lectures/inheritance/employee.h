#ifndef EMPLOYEE_H
#define EMPLOYEE_H
#include <string>

class Employee {
	std::string name;
	int id;
	public:
		Employee();
		Employee(std::string name, int id);
		
		std::string getName() const;
		int getId() const;
		
		void setName(std::string name);
		void setId(int id);
		
		void print() const;
};
#endif
