#include "multiply.h"

double Mult::eval(double v1, double v2)
{
    std::cout << "called multiply for " << v1 << " and " << v2 << std::endl;
    return v1 * v2;
}