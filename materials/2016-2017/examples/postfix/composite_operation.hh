#ifndef COMPOSITE_OPERATION_HH__
#define COMPOSITE_OPERATION_HH__

#include <list>

#include "operation.hh"

class CompositeOperation: public Operation {
    std::list<Operation*> operations_;
public:
    CompositeOperation(const std::string& name);
    ~CompositeOperation();

    void add_operation(Operation* op);

    void execute(Context& context) const;

};

#endif

