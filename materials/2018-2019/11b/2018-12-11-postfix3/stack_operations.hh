#ifndef STACK_OPERATIONS_HH__
#define STACK_OPERATIONS_HH__

#include "operation.hh"

class Dup: public Operation {
public:
	Dup(Calculator& calc)
	: Operation("dup", calc)
	{}
	
	void execute() {
		double v = get_calc().pop();
		get_calc().push(v);
		get_calc().push(v);
	}

};


class Swap: public Operation {
public:
	Swap(Calculator& calc)
	: Operation("swap", calc)
	{}
	
	void execute() {
		double v1 = get_calc().pop();
		double v2 = get_calc().pop();
		
		get_calc().push(v1);
		get_calc().push(v2);
	}

};


#endif
