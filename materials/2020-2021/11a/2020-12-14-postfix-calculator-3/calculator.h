#ifndef CALCULATOR_H
#define CALCULATOR_H
#include <vector>
#include <list>
#include <iostream>
#include <string>

class operation;

class calculator
{
    std::vector<double> values;
    std::list<operation *> operations;
    operation *get_operation(const std::string &token);

public:
    void push(double value);
    int pop();
    void add_operation(operation *op);
    void run(std::istream &in, std::ostream &out);
};

#endif
