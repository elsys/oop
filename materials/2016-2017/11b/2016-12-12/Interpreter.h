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

class Operation;

class Interpreter {
	std::vector<double> stack_;
	std::vector<Operation*> operations_;
public:
	Interpreter();
	virtual ~Interpreter();
	
	void add_operation(Operation* op);
	Operation* find_operation(std::string name) const;
	
	void run();
	
};

#endif /* INTERPRETER_H_ */
