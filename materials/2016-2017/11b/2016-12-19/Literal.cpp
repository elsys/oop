/*
 * Literal.cpp
 *
 *  Created on: Dec 19, 2016
 *      Author: lubo
 */

#include "Literal.h"

Literal::Literal(double val, Interpreter* calc) 
: Operation("literal", calc), val_(val)
{
}

void Literal::eval() const {
    calc_ -> add_value(val_);
}
