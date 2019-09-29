#ifndef INTERPRETER_HH__
#define INTERPRETER_HH__

#include <iostream>
#include <list>

#include "context.hh"
#include "operation.hh"

class SyntaxError {
};

class Interpreter {
    Context context_;
    std::list<Operation*> operations_;

    void macro_definition(const std::string& name, std::istream& in);
public:
    Interpreter();
    ~Interpreter();

    void interpret(std::istream& in);

    void add_operation(Operation* op);
    Operation* get_operation(const std::string& name);
};

#endif

