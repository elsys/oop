#include <iostream>

#include "plus.hh"
#include "context.hh"

Plus::Plus()
        : BinaryOperation("+") {
}

double Plus::do_execute(double a1, double a2) const {
    return a1 + a2;
}

