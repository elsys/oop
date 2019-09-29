#ifndef UNARY_HH_
#define UNARY_HH_

#include <string>
#include "operation.hh"

class UnaryOperation : public Operation {

public:
	UnaryOperation(const std::string& name, Calculator& calc)
			: Operation(name, calc) {}
	
	double execute();

protected:
	virtual double run(double arg) const = 0;
};

#endif
