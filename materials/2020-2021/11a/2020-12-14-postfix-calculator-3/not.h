#ifndef NOT_HH
#define NOT_HH

#include "unary_operation.h"
#include "calculator.h"

class not_operation : public unary_operation {
public:
  not_operation(calculator &calc);

  int eval(int value);
};

#endif
