#include "calculator.h"
#include "operation.h"
#include <sstream>
#include <string>
using namespace std;

void calculator::push(double value)
{
    values.push_back(value);
}

int calculator::pop()
{
    int result = values.back();
    values.pop_back();
    return result;
}

void calculator::add_operation(operation *operation)
{
    operations.push_back(operation);
}

operation *calculator::get_operation(const string &token)
{
    for (list<operation *>::iterator it = operations.begin(); it != operations.end(); it++)
    {
        if ((*it)->get_name() == token)
        {
            return *it;
        }
    }

    return NULL;
}

void calculator::run(istream &in, ostream &out)
{
    while (!in.eof())
    {
        string token;
        getline(in, token);
        istringstream iss(token);
        int value;
        iss >> value;
        if (!iss.fail() && iss.eof())
        {
            push(value);
            cout << "added to stack" << endl;
        }
        else
        {
            cout << "execute operation" << endl;
            operation *op = get_operation(token);
            if (op != NULL)
            {
                op->execute();
                double result = values.back();
            }
            else
            {
                cout << "operation is not defined" << endl;
            }
        }
    }
}

#include "negative.h"
#include "not.h"
#include "plus.h"
#include "multiply.h"

int main()
{
    calculator calc;

    operation *neg = new negative(calc);
    operation *not_ = new not_operation(calc);
    operation *plus_ = new Plus(calc);
    operation *multiply_ = new Mult(calc);

    calc.add_operation(neg);
    calc.add_operation(not_);
    calc.add_operation(plus_);
    calc.add_operation(multiply_);

    calc.run(cin, cout);

    return 0;
}
