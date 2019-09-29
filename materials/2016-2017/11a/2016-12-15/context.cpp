/*
 * context.cpp
 *
 *  Created on: Dec 15, 2016
 *      Author: lubo
 */
#include "context.h"
#include "calculator_error.h"

double Context::pop() {
    if (values.empty()) {
        throw CalculatorError("stack empty");
    }
    double value = values.back();
    values.pop_back();
    return value;
}
void Context::push(double val) {
    values.push_back(val);
}
int Context::size() const {
    return values.size();
}

double Context::peek() const {
    return values.back();
}

