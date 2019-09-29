#include "unary.hh"

void UnaryOperation::execute(){
	double value = get_calc().pop();
	double res = eval(value);
	get_calc().push(res);
}
