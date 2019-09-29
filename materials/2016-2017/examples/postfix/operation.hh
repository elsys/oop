#ifndef OPERATION_HH__
#define OPERATION_HH__

#include <string>

class Context;

class Operation {
    const std::string name_;

public:
    Operation(const std::string& name)
            : name_(name) {
    }

    virtual ~Operation() {
    }

    virtual void execute(Context& context) const =0;

    const std::string& get_name() const {
        return name_;
    }
};

#endif

