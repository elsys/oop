#include <iostream>
#include "calculator.hh"
#include "negate.hh"
#include "square.hh"

using namespace std;

int main() {
	Calculator calc;
	calc.add_operation(new Negate(calc));
	calc.add_operation(new Square(calc));
	calc.run(cin, cout);
	return 0;
}

