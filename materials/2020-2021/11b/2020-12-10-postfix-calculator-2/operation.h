#ifndef OPERATION_H
#define OPERATION_H
#include <string>
#include "calculator.h"

class operation
{
    std::string name;
    calculator &calc;

public:
    operation(const std::string name, calculator &calc) : name(name), calc(calc) {}

    std::string get_name() const { return name; }

    calculator &get_calc() { return calc; }

    virtual void execute() = 0;
};

#endif