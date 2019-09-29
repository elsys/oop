#ifndef CALCULATOR_HH_
#define CALCULATOR_HH_

#include <vector>
#include <iostream>
#include <list>

class Operation;

class Calculator {
	std::vector<double> values_;
	std::list<Operation*> operations_;
	Operation* get_operation(const std::string& name) const;
public:
	void push(double value);
	double pop();
	void run(std::istream& in, std::ostream& out);
	void add_operation(Operation* op);
};

#endif
