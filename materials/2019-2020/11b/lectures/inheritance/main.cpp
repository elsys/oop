#include "employee.h"
#include "manager.h"

int main() {
	Employee e = Employee("Ivan", 1);
	Manager m = Manager("Stoqn", 2, 10);
	e.print();
	m.print();
}
