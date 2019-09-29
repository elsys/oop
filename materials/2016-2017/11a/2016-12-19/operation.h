/*
 * operation.h
 *
 *  Created on: Dec 15, 2016
 *      Author: lubo
 */

#ifndef OPERATION_H_
#define OPERATION_H_

#include <string>

class Context;

class Operation {
    std::string symbol_;
public:
    Operation(std::string symbol)
            : symbol_(symbol) {
    }
    virtual ~Operation() {

    }

    virtual void execute(Context& context) const = 0;

    std::string get_symbol() const {
        return symbol_;
    }
};



#endif /* OPERATION_H_ */
