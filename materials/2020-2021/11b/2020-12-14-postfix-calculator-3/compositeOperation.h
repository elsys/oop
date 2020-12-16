#ifndef COMPOSITE_H
#define COMPOSITE_H
#include "operation.h"
#include <list>

class compositeOperation : public operation
{
    std::list<operation *> operations;

public:
    compositeOperation(const std::string &name, calculator &calc) : operation(name, calc) {}

    void add_operation(operation *op);

    void execute();
};

#endif