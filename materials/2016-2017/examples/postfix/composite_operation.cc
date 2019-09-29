#include "composite_operation.hh"
#include "literal.hh"

CompositeOperation::CompositeOperation(const std::string& name)
        : Operation(name) {
}

CompositeOperation::~CompositeOperation() {
    for (std::list<Operation*>::iterator it = operations_.begin();
            it != operations_.end(); ++it) {

        if (dynamic_cast<Literal*>(*it) != 0) {
            delete *it;
        }
    }
}

void CompositeOperation::add_operation(Operation* op) {
    operations_.push_back(op);
}

void CompositeOperation::execute(Context& context) const {
    for (std::list<Operation*>::const_iterator it =
            operations_.begin(); it != operations_.end(); ++it) {

        (*it)->execute(context);
    }
}

