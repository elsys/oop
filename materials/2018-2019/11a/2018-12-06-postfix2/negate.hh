#ifndef NEGATE_HH__
#define NEGATE_HH__

#include "unary.hh"

class Negate : public UnaryOperation {

public:

	Negate(Calculator& calc) : UnaryOperation("neg", calc) {}
protected:
	double run(double) const;
};

#endif
