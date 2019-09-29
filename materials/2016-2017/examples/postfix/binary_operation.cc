#include "binary_operation.hh"
#include "context.hh"

#include <iostream>

void BinaryOperation::execute(Context& context) const {
    std::stack<double>& args = context.get_argument_stack();

    if (args.empty()) {
        std::cerr << "empty argument stack... can't get arg1"
                << std::endl;
        return;
    }

    double a1 = args.top();
    args.pop();

    if (args.empty()) {
        std::cerr << "empty argument stack... can't get arg2"
                << std::endl;
        return;
    }

    double a2 = args.top();
    args.pop();

    double r = do_execute(a2, a1);
    args.push(r);

}

