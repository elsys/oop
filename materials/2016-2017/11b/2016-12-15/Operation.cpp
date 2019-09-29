/*
 * Operation.cpp
 *
 *  Created on: Dec 12, 2016
 *      Author: lubo
 */

#include "Operation.h"

Operation::Operation(std::string name, Interpreter* calc)
: name_(name), calc_(calc) {}

Operation::~Operation() {}

