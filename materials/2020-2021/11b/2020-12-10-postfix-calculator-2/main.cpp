#include <iostream>
#include "calculator.h"
#include "negate.h"

using namespace std;

int main()
{
    calculator calc;
    
    //negate_op neg =  negate_op(calc);
    calc.add_operation(new negate_op(calc));
    
    calc.run(cin, cout);
    
    //try {
    //  while(1) {
    //    cout << calc.pop() << endl;
    //  }
    //} catch(...) {
    //}
    return 0;
}
