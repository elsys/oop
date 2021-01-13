#include "not.h"

#include <iostream>

not_operation::not_operation(calculator &calc) : unary_operation("not", calc) { }

int not_operation::eval(int value) {
  std::cout << "called not for " << value << std::endl;
  return !value;
}
