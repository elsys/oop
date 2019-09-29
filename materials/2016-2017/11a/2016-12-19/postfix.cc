#include <iostream>
#include <vector>
#include <string>
#include <sstream>

#include "calculator_error.h"
#include "context.h"
#include "operation.h"
#include "binary.h"
#include "calculator.h"

using namespace std;



/*
class UnaryOperation: public Operation {
public:
    UnaryOperation(string symbol)
            : Operation(symbol) {
    }
};
*/



int main() {
    Calculator calc;
    calc.addOperation(new Plus());
    calc.addOperation(new Minus());
    try {
        calc.run(cin, cout);
    } catch (const CalculatorError& err) {
        cout << err.get_message() << endl;
    }
    return 0;
}

