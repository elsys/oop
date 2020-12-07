#include "calculator.h"
#include "operation.h"
#include <sstream>
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
        }
        else
        {
            operation *op = get_operation(token);
            op->execute();
            double result = values.back();
        }
    }
}
