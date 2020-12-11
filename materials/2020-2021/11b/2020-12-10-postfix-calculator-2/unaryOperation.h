#ifndef UNARY_H
#define UNARY_H
#include "operation.h"
class unaryOperation : public operation
{
public:
    unaryOperation(const std::string &name, calculator &calc) : operation(name, calc){};

    void execute();

protected:
    virtual double run(double arg) const = 0;
};
#endif
