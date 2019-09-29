#ifndef SQUARE_HH__
#define SQUARE_HH__

#include "unary.hh"

class Square : public UnaryOperation {

public:
	Square(Calculator& calc) : UnaryOperation("^2", calc) {}
protected:
	double run(double) const;
};


#endif
