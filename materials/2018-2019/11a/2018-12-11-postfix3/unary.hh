#ifndef UNARY_HH__
#define UNARY_HH__

#include <cmath>

#include "operation.hh"

class UnaryOperation : public Operation{

	
public:
	UnaryOperation(const std::string& name, Calculator& calc)
		: Operation(name, calc) {}

	void execute();

protected:
	virtual double eval(double value) = 0;
	

};


class Sqrt: public UnaryOperation {

public:
	Sqrt(Calculator& calc)
		: UnaryOperation("sqrt", calc){}
protected:
	double eval(double value) {
		return std::sqrt(value);
	}

};

#endif
