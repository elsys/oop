#include "calculator.hh"
#include "operation.hh"
#include <iostream>
#include <sstream>
#include <exception>
#include <list>

using namespace std;

void Calculator::push(double value) {
	values_.push_back(value);
}

double Calculator::pop() {
	double result = values_.back();
	values_.pop_back();
	return result;
}

void Calculator::add_operation(Operation* op) {
	operations_.push_back(op);
}

Operation* Calculator::get_operation(const string& name) const {
	for (list<Operation*>::const_iterator it = operations_.begin(); it != operations_.end(); it++) {
		if ((*it) -> get_name() == name) {
			return *it;
		}
	}
	throw exception();
}

void Calculator::run(istream& in, ostream& out) {
	while (!in.eof()) {
		out << "(" << values_.size() << "): ";
		string token;
		getline(in, token);
		istringstream iss(token);
		double value;
		iss >> value;
		if (!iss.fail() && iss.eof()) {
			push(value);
		} else {
			Operation* op = get_operation(token);
			double result = op -> execute();
			out << result << endl;
			push(result);
		}
		
	}
}
