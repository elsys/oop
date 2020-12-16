#ifndef NEGATIVE_HH
#define NEGATIVE_HH

#include "unary_operation.h"
#include "calculator.h"

class negative : public unary_operation {
public:
  negative(calculator &calc);

  int eval(int value);
};

#endif
