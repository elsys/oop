#ifndef PLUS_HH__
#define PLUS_HH__

#include "binary_operation.hh"

class Plus: public BinaryOperation {

public:
    Plus();

protected:
    virtual double do_execute(double a1, double a2) const;
};

#endif

