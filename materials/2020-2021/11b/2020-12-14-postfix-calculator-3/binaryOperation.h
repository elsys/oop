#ifndef BINARY_H
#define BINARY_H

#include "operation.h"

class binaryOperation : public operation
{
public:
    binaryOperation(const std::string &name, calculator &calc) : operation(name, calc) {}

    void execute();

protected:
    virtual double eval(double v1, double v2) = 0;
};
#endif