#ifndef BINARY_HH__
#define BINARY_HH__

#include "operation.hh"

class BinaryOperation : public Operation{

	
public:
	BinaryOperation(const std::string& name, Calculator& calc)
		: Operation(name, calc) {}

	void execute();

protected:
	virtual double eval(double v1, double v2) = 0;
};


class Plus: public BinaryOperation {

public:
	Plus(Calculator& calc)
	: BinaryOperation("+", calc)
	{}

protected:
	double eval(double v1, double v2) {
		return v1 + v2;
	}
};

class Mult: public BinaryOperation {

public:
	Mult(Calculator& calc)
	: BinaryOperation("*", calc)
	{}

protected:
	double eval(double v1, double v2) {
		return v1 * v2;
	}
};


#endif
