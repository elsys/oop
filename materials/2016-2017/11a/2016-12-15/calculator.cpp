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

        Operation* operation = get_operation(input);
        if (operation) {
            try {
                operation->execute(context);
                cout << "res> " << context.peek() << endl;

            } catch (const CalculatorError& ex) {
                cerr << ">>> error in executing "
                        << operation->get_symbol()
                        << "; "
                        << ex.get_message()
                        << endl;
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

void Calculator::addOperation(Operation* operation) {
    operations_.push_back(operation);
}




