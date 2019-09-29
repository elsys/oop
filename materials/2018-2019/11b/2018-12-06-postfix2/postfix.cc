#include "calculator.hh"
#include <iostream>
#include "negate.hh"

int main() {
	Calculator calc;
	calc.add_operation(new Negate(calc));
	calc.run(std::cin, std::cout);
	return 0;
}
