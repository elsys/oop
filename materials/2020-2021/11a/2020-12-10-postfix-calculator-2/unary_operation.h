#ifndef UNARY_OPERATION_HH
#define UNARY_OPERATION_HH

#include "operation.h"

class unary_operation : public operation {
public:
  unary_operation(const std::string name, calculator &calc) : operation(name, calc) {};

  void execute() {
    int value = get_calc().pop();

    int result = eval(value); // Perform operation and get new value

    get_calc().push(result);
  }

  virtual int eval(int value) = 0;
};

#endif
