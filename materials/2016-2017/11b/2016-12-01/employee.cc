#include <iostream>
#include <string>
#include <vector>

using namespace std;

class Employee {

protected:
    long id_;
    string name_;
    
public:
    
    Employee(long id, string name) : id_(id), name_(name) {}

    long get_id() const {
        return id_;
    }
    
    string get_name() const {
        return name_;
    }
    
    virtual void print() const {
        cout << "id: " << id_ << "; name: " << name_ << endl;
    }
};

class Manager: public Employee {
    
    long level_;
    
public:

    Manager(long id, string name, long level)
        : Employee(id, name), level_(level) {}

    void print() const {
        cout << "level: " << level_ << "; ";
        Employee::print();
    }
};

void fire(Employee& e) {
    cout << "FIRED: ";
    e.print();
}

int main() {
    Employee e1(1, "Ivan Ivanov");
    e1.print();
    
    Manager m1(2, "Peter Petrov", 1);
    m1.print();
    
    vector<Employee*> employees;
    employees.push_back(&e1);
    employees.push_back(&m1);
    
    cout << "printing from vector with employees" << endl; 
    for (vector<Employee*>::iterator it = employees.begin();
            it != employees.end(); it++) {
        (*it) -> print();
    }
    
    cout << "printing manager from employee variable" << endl;
    Employee e2 = m1;
    e2.print();
    
    cout << "printing manager from employee reference" << endl;
    Employee& e3 = m1;
    e3.print();
    
    fire(m1);
    fire(e1);

    return 0;
}








