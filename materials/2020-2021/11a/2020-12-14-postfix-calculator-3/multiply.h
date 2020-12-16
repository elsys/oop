#ifndef MULTIPLY_H
#define MULTIPLY_H
#include "binary_operation.h"

class Mult : public binary_operation
{

public:
    Mult(calculator &calc) : binary_operation("*", calc){};

    double eval(double v1, double v2);
};

#endif