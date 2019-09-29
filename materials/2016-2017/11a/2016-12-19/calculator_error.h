/*
 * calculator_error.h
 *
 *  Created on: Dec 15, 2016
 *      Author: lubo
 */

#ifndef CALCULATOR_ERROR_H_
#define CALCULATOR_ERROR_H_

#include <string>

class CalculatorError {
    std::string message_;
public:
    CalculatorError(std::string message)
            : message_(message) {
    }

    std::string get_message() const {
        return message_;
    }
};



#endif /* CALCULATOR_ERROR_H_ */
