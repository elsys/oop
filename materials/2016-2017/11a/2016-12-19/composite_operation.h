#ifndef COMPOSITE_OPERATION_H__
#define COMPOSITE_OPERATION_H__

#include <string>
#include <vector>
#include "operation.h"
#include "context.h"

using namespace std;

class CompositeOperation: public Operation {
	vector<Operation*> operations;
public:
	CompositeOperation(string symbol)
		: Operation(symbol) {}
	
	~CompositeOperation() {
		
	}
	
	void add_operation(Operation* operation);
	void execute(Context& context) const;
};

class Literal: public Operation {
	double value_;
public:
	Literal(double value) : Operation("literal"), value_(value) {}

	void execute(Context& context) const {
		context.push(value_);
	}
};

#endif
