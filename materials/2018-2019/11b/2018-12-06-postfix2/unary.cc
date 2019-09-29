#include "unary.hh"

double UnaryOperation::execute(){
	double value = get_calc().pop();
	return eval(value);
}
