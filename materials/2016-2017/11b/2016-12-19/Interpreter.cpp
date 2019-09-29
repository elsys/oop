/*
 * Interpreter.cpp
 *
 *  Created on: Dec 12, 2016
 *      Author: lubo
 */

#include "Interpreter.h"
#include "Operation.h"
#include "Macro.h"
#include "Literal.h"

#include <iostream>
#include <sstream>

Interpreter::Interpreter() {
}

Interpreter::~Interpreter() {
}

void Interpreter::add_operation(Operation* op) {
    operations_.push_back(op);
}

Operation* Interpreter::find_operation(std::string name) const {
    for (std::vector<Operation*>::const_iterator it =
            operations_.begin(); it != operations_.end(); ++it) {

        if (name == (*it)->get_name()) {
            return *it;
        }
    }
    return NULL;
}

void Interpreter::run() {
    std::string token;

    while (true) {
        std::cin >> token;
        if (!std::cin) {
            break;
        }
        if (token[0] == '\\') {
            // definition start
            std::string name = token.substr(1);
            std::cout << "defining: " << name << std::endl;
            Macro* macro = new Macro(name, this);
            while(true) {
                std::cin >> token;
                if(token == "def") {
                    std::cout << "end definition of "
                            << macro->get_name() << std::endl;
                    add_operation(macro);
                    break;
                } else {
                    Operation* op = find_operation(token);
                    if(op != NULL) {
                        std::cout << "adding op "
                                << op->get_name() << std::endl;
                        macro->add_operation(op);
                    } else {
                        // token is a number??
                        double number;
                        std::istringstream istr(token);
                        istr >> number;
                        if (istr) {
                            Literal* op = new Literal(number, this);
                            std::cout << "adding literal "
                                    << number << std::endl;
                            macro->add_operation(op);
                        } else {
                            throw InterpreterException("unknown operation");
                        }

                    }
                }
            }
        } else {

            Operation* op = find_operation(token);
            if (op != NULL) {
                // operation found!!!
                op->eval();
            } else {
                // check if number??
                double number;
                std::istringstream istr(token);
                istr >> number;
                if (istr) {
                    add_value(number);
                } else {
                    throw InterpreterException("unknown operation");
                }
            }
        }
    }
}
