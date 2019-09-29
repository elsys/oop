#include "interpreter.hh"
#include "plus.hh"
#include "binary_operation.hh"

#include <iostream>

class Minus: public BinaryOperation {
public:
    Minus()
            : BinaryOperation("-") {
    }

protected:
    double do_execute(double a1, double a2) const {
        return a1 - a2;
    }
};

int main(int argc, char* argv[]) {

    Interpreter calc;
    calc.add_operation(new Plus());
    calc.add_operation(new Minus());

    calc.interpret(std::cin);

    return 0;
}

