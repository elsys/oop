/*
 * Minus.cpp
 *
 *  Created on: Dec 19, 2016
 *      Author: lubo
 */

#include "Minus.h"

Minus::Minus(Interpreter* calc) 
: Operation("-", calc)
{}

void Minus::eval() const {
    double val1 = calc_ -> get_value();
    double val2 = calc_ -> get_value();
    
    calc_ -> add_value(val2 - val1);
    
}
