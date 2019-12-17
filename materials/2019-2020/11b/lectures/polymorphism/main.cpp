#include "employee.h"
#include "manager.h"
#include <vector>

using namespace std;

void printAll(vector<Employee*>& v) {
	for (vector<Employee*>::iterator it = v.begin(); it != v.end(); it++) {
		(*it) -> print();
	}
}

int main() {
	vector<Employee*> employees;
	
	Employee e = Employee("Ivan", 1242342121);
	Manager m = Manager("Petkan", 13532422342, 10);
	
	employees.push_back(&e);
	employees.push_back(&m);
	
	printAll(employees);
	
	return 0;
}
