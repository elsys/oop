#include "compositeOperation.h"

void compositeOperation::add_operation(operation *op)
{
    operations.push_back(op);
}

void compositeOperation::execute()
{
    for (std::list<operation *>::iterator it = operations.begin(); it != operations.end(); it++)
    {
        (*it)->execute();
    }
}