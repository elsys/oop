#ifndef NEGATE_H
#define NEGATE_H

#include "unaryOperation.h"

class negate_op : public unaryOperation
{
public:
    negate_op(calculator &calc) : unaryOperation("neg", calc){};

protected:
    double run(double value) const;
};
#endif
