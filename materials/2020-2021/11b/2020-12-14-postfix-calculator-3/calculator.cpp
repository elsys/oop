#include "calculator.h"
#include "operation.h"
#include <sstream>

#include <iostream>

using namespace std;

void calculator::push(double value)
{
    values.push_back(value);
}

double calculator::pop()
{
    double result = values.back();
    values.pop_back();
    return result;
}

void calculator::add_operation(operation *op)
{
    operations.push_back(op);
}

operation *calculator::get_operation(const string &name) const
{
    for (list<operation *>::const_iterator it = operations.begin(); it != operations.end(); it++)
    {
        if ((*it)->get_name() == name)
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
        double value;
        istringstream iss(token);
        iss >> value;
        if (!iss.fail() && iss.eof())
        {
            cout << "add " << value << " to stack" << endl;
            push(value);
        }
        else
        {
            cout << "execute operation " << token << endl;
            operation *op = get_operation(token);
            if (op != NULL)
            {
                op->execute();
            }
            else
            {
                cout << "no such operation" << endl;
            }
            printValues();
        }
    }
}

void ::calculator::printValues() const
{
    cout << "values: " << endl;
    for (int i = 0; i < values.size(); i++)
    {
        cout << values[i] << endl;
    }
}