#ifndef OPERATION_HH_
#define OPERATION_HH_

#include "calculator.hh"
#include <string>

class Operation {
	std::string name_;
	Calculator& calc_;

public:
	Operation(const std::string& name, Calculator& calc) : name_(name), calc_(calc) {}

	std::string get_name() const {
		return name_;
	}
	
	Calculator& get_calc() const {
		return calc_;
	}

	virtual double execute() = 0;

};

#endif
