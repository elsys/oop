#ifndef OPERATION_H
#define OPERATION_H
#include <string>
#include "calculator.h"
#include <string>
using namespace std;

class operation
{
    std::string name;
    calculator &calc;

public:
    operation(const std::string name, calculator &calc) : name(name), calc(calc){};

    std::string get_name()
    {
        return name;
    }

    calculator &get_calc()
    {
        return calc;
    }

    virtual void execute() = 0;
};

#endif