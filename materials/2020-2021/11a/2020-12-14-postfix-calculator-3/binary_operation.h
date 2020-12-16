#ifndef BINARY_HH
#define BINARY_HH
#include "operation.h"

class binary_operation : public operation
{
public:
    binary_operation(const std::string name, calculator &calc) : operation(name, calc) {}

    void execute()
    {
        double v1 = get_calc().pop();
        double v2 = get_calc().pop();
        double res = eval(v2, v1);
        get_calc().push(res);
    }

    virtual double eval(double v1, double v2) = 0;
};

#endif