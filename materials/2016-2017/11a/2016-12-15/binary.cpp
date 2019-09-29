/*
 * binary.cpp
 *
 *  Created on: Dec 15, 2016
 *      Author: lubo
 */
#include "binary.h"
#include "context.h"
#include "calculator_error.h"

using namespace std;

BinaryOperation::BinaryOperation(string symbol)
        : Operation(symbol) {
}

void BinaryOperation::execute(Context& context) const {
    if (context.size() < 2) {
        throw CalculatorError("not enough values...");
    }
    double value1 = context.pop();
    double value2 = context.pop();
    context.push(eval(value1, value2));
}

Plus::Plus()
            : BinaryOperation("+") {
}

double Plus::eval(double value1, double value2) const {
    return value1 + value2;
}


Minus::Minus()
        : BinaryOperation("-") {
}
double Minus::eval(double value1, double value2) const {
    return value1 - value2;
}

