/*
 * Interpreter.h
 *
 *  Created on: Dec 12, 2016
 *      Author: lubo
 */

#ifndef INTERPRETER_H_
#define INTERPRETER_H_
#include <vector>
#include <string>
#include <iostream>

class Operation;

class InterpreterException {
	std::string message_;
public:
	InterpreterException(std::string message) : message_(message) {}
	
	std::string get_message() const {
		return message_;
	}
};

class Interpreter {
	std::vector<double> stack_;
	std::vector<Operation*> operations_;
public:
	Interpreter();
	virtual ~Interpreter();
	
	double get_value() {
		if (stack_.empty()) {
			throw InterpreterException("not enough values in stack");
		}
		double result = stack_.back();
		stack_.pop_back();
		return result;
	}
	void add_value(double value) {
		std::cout << "> " << value << std::endl; 
		stack_.push_back(value);
	}
	
	void add_operation(Operation* op);
	Operation* find_operation(std::string name) const;
	
	void run();
	
};

#endif /* INTERPRETER_H_ */
