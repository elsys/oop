#include <iostream>
#include <string>

using namespace std;


class Employee {
// protected:
	string name_;
	long id_;
public:
	Employee(string name, long id)
	: name_(name),
		id_(id)
	{}

	Employee() 
	{
		cout << "Employee() called..." << endl;
	}

	string get_name() const {
		return name_;
	}

	long get_id() const {
		return id_;
	}
	
	virtual void print() const {
		cout << "E: " << name_ << " " << id_ << endl;
	}
};

class Manager: public Employee {

	long level_;
public:
	Manager(string name, long id, long level)
	: Employee(name, id),
		level_(level)
	{}


	long get_level() const {
		return level_;
	}
	
	void print() const {
		//cout << "M: " << name_ << " " << id_ << " " << level_ << endl;
		cout << "M: " << get_name() << " " << get_id() << " " 
				<< get_level() << endl;
	}
};



int main() {
	Employee e1("john", 0);
	Manager m1("boss", 42, -1);	

	cout << e1.get_name() << " " << e1.get_id() << endl;
	cout << m1.get_name() << " " << m1.get_id() << " " 
			<< m1.get_level() << endl;
			
	// e1.get_level();

	Employee e2 = m1;
	cout << e2.get_name() << " " << e2.get_id() << endl;
	
	m1.print();
	e1.print();
	
	Employee* p1 = &e1;
	p1->print();
	
	Employee* p2 = &m1;
	p2->print();
	
	return 0;
}




