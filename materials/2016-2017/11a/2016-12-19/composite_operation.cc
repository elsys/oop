#include <vector>
#include "composite_operation.h"
#include "context.h"

void CompositeOperation::add_operation(Operation* operation) {
	operations.push_back(operation);
}

void CompositeOperation::execute(Context& context) const {
	for (vector<Operation*>::const_iterator it = operations.begin(); it != operations.end(); it++) {
		(*it) -> execute(context);
	}
}
