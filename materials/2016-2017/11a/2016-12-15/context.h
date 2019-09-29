/*
 * context.h
 *
 *  Created on: Dec 15, 2016
 *      Author: lubo
 */

#ifndef CONTEXT_H_
#define CONTEXT_H_
#include <vector>

class Context {
    std::vector<double> values;
public:
    double pop();
    void push(double val);
    int size() const;

    double peek() const;
};


#endif /* CONTEXT_H_ */
