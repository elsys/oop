#ifndef PLUS_H
#define PLUS_H
#include "binaryOperation.h"

class Plus : public binaryOperation
{

public:
    Plus(calculator &calc) : binaryOperation("+", calc) {}

protected:
    double eval(double v1, double v2);
};

#endif