#ifndef MULTIPLY_H
#define MULTIPLY_H
#include "binaryOperation.h"

class Mult : public binaryOperation
{
public:
    Mult(calculator &calc) : binaryOperation("*", calc) {}

protected:
    double eval(double v1, double v2);
};

#endif