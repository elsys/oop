/*
 * binary.h
 *
 *  Created on: Dec 15, 2016
 *      Author: lubo
 */

#ifndef BINARY_H_
#define BINARY_H_

#include <string>

#include "operation.h"

class Context;

class BinaryOperation: public Operation {
public:
    BinaryOperation(std::string symbol);
    void execute(Context& context) const;
protected:
    virtual double eval(double value1, double value2) const = 0;
};

class Plus: public BinaryOperation {
public:
    Plus();
protected:
    double eval(double value1, double value2) const;
};

class Minus: public BinaryOperation {
public:
    Minus();
protected:
    double eval(double value1, double value2) const;
};



#endif /* BINARY_H_ */
