#ifndef CALCULATOR_H
#define CALCULATOR_H
#include <vector>
#include <list>
#include <iostream>

class operation;

class calculator
{
    std::vector<double> values;
    std::list<operation *> operations;

public:
    void push(double value);
    double pop();
    void add_operation(operation *op);
    void run(std::istream &in, std::ostream &out);
    operation *get_operation(const std::string &name) const;
};

#endif