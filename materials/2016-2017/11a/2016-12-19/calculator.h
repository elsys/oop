/*
 * calculator.h
 *
 *  Created on: Dec 15, 2016
 *      Author: lubo
 */

#ifndef CALCULATOR_H_
#define CALCULATOR_H_
#include<string>
#include<vector>
#include<iostream>

#include "operation.h"
#include "context.h"

class Calculator {
// 1. easily switch to different input streams
// 2. easily add new operations
    std::vector<Operation*> operations_;
    Context context;

    Operation* get_operation(std::string symbol);

	void define_new_operation(std::string operation_name, std::istream& in);
public:

    void run(std::istream& in, std::ostream& out);
    void addOperation(Operation* operation);
};




#endif /* CALCULATOR_H_ */
