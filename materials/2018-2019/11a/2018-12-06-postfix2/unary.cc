#include "unary.hh"

double UnaryOperation::execute() {
	return run(get_calc().pop());
}

