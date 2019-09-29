/*
 * Minus.h
 *
 *  Created on: Dec 19, 2016
 *      Author: lubo
 */

#ifndef MINUS_H_
#define MINUS_H_

#include "Operation.h"

class Minus: public Operation {
public:
    Minus(Interpreter* calc);
    
    void eval() const;
};

#endif /* MINUS_H_ */
