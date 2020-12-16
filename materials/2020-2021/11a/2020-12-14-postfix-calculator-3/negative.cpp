#include "negative.h"

#include <iostream>

negative::negative(calculator &calc) : unary_operation("neg", calc) { }

int negative::eval(int value) {
  std::cout << "called negative for " << value << std::endl;
  return -value;
}
