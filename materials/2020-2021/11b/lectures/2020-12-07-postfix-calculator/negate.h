#ifndef NEGATE_H
#define NEGATE_H

#include "unaryOperation.h"

class negate : public unaryOperation
{
public:
    negate(calculator &calc) : unaryOperation("neg", calc){};

protected:
    double run(double value) const;
};
#endif