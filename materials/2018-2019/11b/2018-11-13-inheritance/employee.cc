#include <iostream>
#include <string>
using namespace std;


class Employee {
	int id_;
	string name_;
protected:
	// int pv_;
	
public:
	Employee(int id, const string& name)
	: id_(id), name_(name)
	{}
	
	int get_id() const {
		return id_;
	}
	
	const string& get_name() const {
		return name_;
	}
	
	void print() const {
		cout << "name: " << name_ << "; id: " << id_ << endl;
	}
};

class Manager: public Employee {
	int level_;
public:
	Manager(int id, const string& name, int level)
	: Employee(id, name),
	  level_(level)
	{}

	
	int get_level() const {
		return level_;
	}
	
	void print() const {
		Employee::print();
		
		cout << "level: " << level_ << "; "
			<< "name: " << get_name() << "; id: " << get_id() << endl;
		// cout << pv_;
	}
};


void foo(const Employee& e) {
	e.print();
}

int main() {
	Employee e1(1, "ivan");
	Employee e2(2, "pesho");
	// cout << e1.pv_ << endl;
	
	Manager m1(1000, "shef", 1);
	
	cout << "name: " << e1.get_name() << "; id: " << e1.get_id() << endl;
	cout << "name: " << m1.get_name() << "; id: " << m1.get_id() 
		<< "; level: " << m1.get_level() << endl;

	cout << endl << endl;
	
	e1.print();
	e2.print();
	m1.print();

	Employee e = m1;

	foo(e1);
	foo(m1);

	Employee* pe[3];
	
	pe[0] = &e1;
	pe[1] = &e2;
	pe[2] = &m1;

	for(int i=0; i<3; ++i) {
		pe[i] -> print();
	}

	return 0;
}

