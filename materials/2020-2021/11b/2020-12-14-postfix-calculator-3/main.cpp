#include <iostream>
#include "calculator.h"
#include "negate.h"
#include "plus.h"
#include "multiply.h"
#include "compositeOperation.h"

using namespace std;

int main()
{
    calculator calc;

    /*
        asd -> operation
            -> +
            -> *
            -> neg

        2
        3
        4
        asd


        7 -> 14 -> -14

    

    calc.add_operation(new negate_op(calc));
    calc.add_operation(new Plus(calc));
    calc.add_operation(new Mult(calc));
    */
    compositeOperation *comp = new compositeOperation("asd", calc);
    comp->add_operation(new Plus(calc));
    comp->add_operation(new Mult(calc));
    comp->add_operation(new negate_op(calc));

    calc.add_operation(comp);

    calc.run(cin, cout);

    return 0;
}
