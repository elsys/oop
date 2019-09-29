#include <sstream>

#include "interpreter.hh"
#include "composite_operation.hh"
#include "literal.hh"

Interpreter::Interpreter() {

}

Interpreter::~Interpreter() {

    for (std::list<Operation*>::reverse_iterator it =
            operations_.rbegin(); it != operations_.rend(); ++it) {

        delete *it;
    }
}

void Interpreter::add_operation(Operation* op) {
    operations_.push_back(op);
}

Operation* Interpreter::get_operation(const std::string& name) {
    for (std::list<Operation*>::iterator it = operations_.begin();
            it != operations_.end(); ++it) {

        if ((*it)->get_name() == name) {
            return *it;
        }
    }
    return 0;
}

void Interpreter::interpret(std::istream& in) {

    while (in) {
        std::string word;

        in >> word;
        if (!in) {
            return;
        }
        if (word[0] == '\\') {
            // macro definition
            macro_definition(word, in);
        } else {

            Operation* op = get_operation(word);
            if (op != 0) {
                op->execute(context_);
                std::cerr << "RES: "
                        << context_.get_argument_stack().top()
                        << std::endl;
            } else {
                std::istringstream is(word);
                double arg = 0.0;
                is >> arg;
                if (!is.fail()) {
                    context_.get_argument_stack().push(arg);
                    std::cerr << "ARG: " << arg << std::endl;
                } else {

                    std::cerr << "invalid syntax <" << word << ">!!!!"
                            << std::endl;
                    return;
                }
            }
        }
    }

}

void Interpreter::macro_definition(const std::string& name,
        std::istream& in) {

    CompositeOperation* macro = new CompositeOperation(
            name.substr(1, name.size() - 1));

    while (1) {
        std::string word;
        in >> word;
        if (!in) {
            throw SyntaxError();
        }
        if (word == "def") {
            add_operation(macro);
            return;
        }
        Operation* op = get_operation(word);
        if (op != 0) {
            macro->add_operation(op);
        } else {
            std::istringstream is(word);
            double arg = 0.0;
            is >> arg;
            if (!is.fail()) {
                macro->add_operation(new Literal(arg));
            } else {

                std::cerr << "invalid syntax <" << word << ">!!!!"
                        << std::endl;
                throw SyntaxError();
            }

        }

    }

}

