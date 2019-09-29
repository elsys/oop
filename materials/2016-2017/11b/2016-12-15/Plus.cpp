/*
 * Plus.cpp
 *
 *  Created on: Dec 12, 2016
 *      Author: lubo
 */

#include "Plus.h"

Plus::Plus(Interpreter* calc)
: Operation("+", calc) {}

void Plus::eval() const {
	double arg1 = calc_ -> get_value();
	double arg2 = calc_ -> get_value();
	calc_ -> add_value(arg1 + arg2);
}
