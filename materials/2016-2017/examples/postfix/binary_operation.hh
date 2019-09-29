#ifndef BINARY_OPERATION_HH__
#define BINARY_OPERATION_HH__

#include "operation.hh"

class BinaryOperation: public Operation {

public:
    BinaryOperation(const std::string& name)
            : Operation(name) {
    }

    void execute(Context& context) const;

protected:
    virtual double do_execute(double a1, double a2) const=0;

};

#endif

