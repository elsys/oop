/*
 * Macro.cpp
 *
 *  Created on: Dec 19, 2016
 *      Author: lubo
 */

#include "Macro.h"
#include "Interpreter.h"

Macro::Macro(std::string name, Interpreter* calc)
: Operation(name, calc)
{
}

Macro::~Macro() {
    // TODO Auto-generated destructor stub
}


void Macro::eval() const {
    for(std::vector<Operation*>::const_iterator it = ops_.begin();
        it!= ops_.end();
        ++it) {
    
        (*it) ->eval();
    }
    
}

void Macro::add_operation(Operation* op) {
    ops_.push_back(op);
}


