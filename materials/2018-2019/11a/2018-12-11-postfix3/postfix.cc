#include "calculator.hh"
#include <iostream>

#include "negate.hh"
#include "binary.hh"
#include "unary.hh"
#include "stack_operations.hh"
#include "composite.hh"


int main() {
	Calculator calc;
	calc.add_operation(new Negate(calc));
	calc.add_operation(new Plus(calc));
	calc.add_operation(new Mult(calc));
	calc.add_operation(new Sqrt(calc));
	calc.add_operation(new Dup(calc));
	calc.add_operation(new Swap(calc));
	
	CompositeOperation* hypo = new CompositeOperation("hypo", calc);
	hypo->add_operation(new Dup(calc));
	hypo->add_operation(new Mult(calc));
	hypo->add_operation(new Swap(calc));
	hypo->add_operation(new Dup(calc));
	hypo->add_operation(new Mult(calc));
	hypo->add_operation(new Plus(calc));
	hypo->add_operation(new Sqrt(calc));
	
	calc.add_operation(hypo);	
	
	calc.run(std::cin, std::cout);
	return 0;
}
