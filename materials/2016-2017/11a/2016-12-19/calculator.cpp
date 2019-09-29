/*
 * calculator.cpp
 *
 *  Created on: Dec 15, 2016
 *      Author: lubo
 */
#include <iostream>
#include <sstream>

#include "calculator.h"
#include "operation.h"
#include "calculator_error.h"
#include "context.h"
#include "composite_operation.h"

using namespace std;

Operation* Calculator::get_operation(string symbol) {
    for (vector<Operation*>::iterator it = operations_.begin();
            it != operations_.end(); it++) {
        if ((*it)->get_symbol() == symbol) {
            return *it;
        }
    }
    return 0;
}

void Calculator::run(istream& in, ostream& out) {
    while (1) {
        out << "values(" << context.size() << "): ";
        string input;
        in >> input;

        if (!in) {
            break;
        }
        if (input[0] == '\\') {
            define_new_operation(input, in);
        } else {
            Operation* operation = get_operation(input);
            if (operation) {
                try {
                    operation->execute(context);
                    cout << "res> " << context.peek() << endl;

                } catch (const CalculatorError& ex) {
                    cerr << ">>> error in executing "
                            << operation->get_symbol() << "; "
                            << ex.get_message() << endl;
                }
            } else {
                // is it a double?
                double new_value;
                stringstream istr(input);
                istr >> new_value;
                if (istr) {
                    context.push(new_value);
                } else {
                    throw CalculatorError("unknown operation...");
                }
            }
        }
    }
}

void Calculator::define_new_operation(string operation_name,
        istream& in) {
    CompositeOperation* new_operation = new CompositeOperation(
            operation_name.substr(1));

    while (1) {
        string input;
        in >> input;

        if (!in) {
            break;
        }

        Operation* operation = get_operation(input);
        if (operation) {
            new_operation->add_operation(operation);
        } else if (input == "def") {
            break;
        } else {
            double new_value;
            stringstream istr(input);
            istr >> new_value;
            if (istr) {
                new_operation->add_operation(new Literal(new_value));
            } else {
                delete new_operation;
                cout << "unknown op" << endl;
                throw CalculatorError("unknown operation...");
            }
        }
    }

    addOperation(new_operation);
}

void Calculator::addOperation(Operation* operation) {
    cout << "operation added: " << operation->get_symbol() << endl;
    operations_.push_back(operation);
}

