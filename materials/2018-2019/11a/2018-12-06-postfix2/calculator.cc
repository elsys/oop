#include "calculator.hh"
#include "operation.hh"
#include <iostream>
#include <sstream>
#include <string>
#include <exception>

using namespace std;

void Calculator::push(double value) {
	values_.push(value);
}

double Calculator::pop() {
	if (values_.size() == 0) {
		throw exception();
	}
	double result = values_.top();
	values_.pop();
	return result;
}

Operation* Calculator::get_operation(string name) const {
	for (list<Operation*>::const_iterator it = operations_.begin(); it != operations_.end(); it++) {
		if ((*it) -> get_name() == name) {
			return *it;
		}
	}
	throw exception();
}

void Calculator::add_operation(Operation* operation) {
	// TODO check if already existing
	operations_.push_back(operation);
}

void Calculator::run(istream& in, ostream& out) {
	string token;
	while (!in.eof()) {
		cout << "(" << values_.size() << "): ";
		getline(in, token);
		istringstream iss(token);
		double value;
		iss >> value;
		if (!iss.fail() && iss.eof()) {
			push(value);
		} else {
			Operation* op = get_operation(token);
			double value = op -> execute();
			out << value << endl;
			push(value);
		}
	}
}
