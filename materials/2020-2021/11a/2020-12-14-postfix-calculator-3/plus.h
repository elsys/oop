#ifndef PLUS_H
#define PLUS_H
#include "binary_operation.h"

class Plus : public binary_operation
{
public:
    Plus(calculator &calc);

protected:
    double eval(double v1, double v2);
};

#endif