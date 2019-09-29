/*
 * Literal.h
 *
 *  Created on: Dec 19, 2016
 *      Author: lubo
 */

#ifndef LITERAL_H_
#define LITERAL_H_
#include "Operation.h"

class Literal: public Operation {
    double val_;
public:
    Literal(double val, Interpreter* calc);
    void eval() const;
};

#endif /* LITERAL_H_ */
