#include "unaryOperation.h"
#include <iostream>

void unaryOperation::execute()
{
    double value = get_calc().pop();
    std::cout << "execute unary for " << value << std::endl;
    double res = run(value);
    
    get_calc().push(res);
}
