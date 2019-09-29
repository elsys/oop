#ifndef NEGATE_HH__
#define NEGATE_HH_

#include "unary.hh"

class Negate : public UnaryOperation{

public:
	Negate(Calculator& calc)
		: UnaryOperation("neg", calc){}
protected:
	double eval(double value);
};

#endif
