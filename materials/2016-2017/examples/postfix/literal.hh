#ifndef LITERAL_HH__
#define LITERAL_HH__

#include "context.hh"

class Literal: public Operation {
    double value_;
public:
    Literal(double v)
            : Operation("literal"), value_(v) {
    }

    void execute(Context& context) const {
        context.get_argument_stack().push(value_);
    }
};

#endif

