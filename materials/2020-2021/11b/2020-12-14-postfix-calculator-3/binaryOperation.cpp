#include "binaryOperation.h"

void binaryOperation::execute()
{
    double v1 = get_calc().pop();
    double v2 = get_calc().pop();
    std::cout << "execute binary for " << v1 << " and " << v2 << std::endl;
    double result = eval(v1, v2);
    get_calc().push(result);
}