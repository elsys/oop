/*
 * Interpreter.cpp
 *
 *  Created on: Dec 12, 2016
 *      Author: lubo
 */

#include "Interpreter.h"
#include "Operation.h"

#include <iostream>
#include <sstream>

Interpreter::Interpreter() {
}

Interpreter::~Interpreter() {
}

void Interpreter::add_operation(Operation* op) {
	operations_.push_back(op);
}

Operation* Interpreter::find_operation(std::string name) const {
	for(std::vector<Operation*>::const_iterator it=operations_.begin();
		it!=operations_.end(); ++it) {
		
		if(name == (*it)->get_name()) {
			return *it;
		}
	}
	return NULL;
}

void Interpreter::run() {
	std::string token;
	
	while(true) {
		std::cin >> token;
		if(!std::cin) {
			break;
		}
		Operation* op = 
			find_operation(token);
		if(op != NULL) {
			// operation found!!!
			
		} else {
			// check if number??
			double number;
			std::istringstream istr(token);
			istr >> number;
			if(istr) {
				std::cout << "> " << number << std::endl;
				stack_.push_back(number);
			} else {
				std::cerr << "unknown operation!!" 
					<< std::endl;
			}
		}
	}	
}

