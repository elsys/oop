#ifndef COMPOSITE_HH__
#define COMPOSITE_HH__

#include "operation.hh"
#include <list>

class Composite: public Operation {
	std::list<Operation*> operations_;
public:

	Composite(const std::string& name, Calculator& calc)
	: Operation(name, calc)
	{}
	
	void add_operation(Operation* op) {
		operations_.push_back(op);
	}
	
	void execute() {
		for(std::list<Operation*>::iterator it= operations_.begin();
			it!=operations_.end(); ++it) {
		
			(*it) -> execute();	
		}
	}

};

#endif

