/*
 * Macro.h
 *
 *  Created on: Dec 19, 2016
 *      Author: lubo
 */

#ifndef MACRO_H_
#define MACRO_H_
#include <string>

#include "Operation.h"
#include "Interpreter.h"

class Macro: public Operation {
    std::vector<Operation*> ops_;

public:
    Macro(std::string name, Interpreter* calc);
    virtual ~Macro();
    
    void eval() const;
    
    void add_operation(Operation* op);
};

#endif /* MACRO_H_ */
