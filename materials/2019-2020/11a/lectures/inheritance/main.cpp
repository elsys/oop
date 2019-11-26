#include "employee.h"
#include "manager.h"

int main() {
	Employee e = Employee("Ivan" , 1);
	Manager m = Manager("Manokl", 2, 12);
	e.print();
	m.print();
}
