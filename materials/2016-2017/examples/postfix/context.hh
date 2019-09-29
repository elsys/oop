#ifndef CONTEXT_HH__
#define CONTEXT_HH__

#include <stack>

class Context {
    std::stack<double> argument_stack_;
public:

    std::stack<double>& get_argument_stack() {
        return argument_stack_;
    }

};

#endif

