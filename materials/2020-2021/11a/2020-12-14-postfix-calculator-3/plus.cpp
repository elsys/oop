#include "plus.h"

Plus::Plus(calculator &calc) : binary_operation("+", calc) {}

double Plus::eval(double v1, double v2)
{
    std::cout << "called plus for " << v1 << " and " << v2 << std::endl;
    return v1 + v2;
}