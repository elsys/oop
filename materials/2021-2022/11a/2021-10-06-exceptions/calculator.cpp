#include <iostream>
using namespace std;

double division(int a, int b)
{
    try
    {
        if (b == 0)
        {
            throw "Can't divide by zero";
        }
    }
    catch (const char *ex)
    {
    }
    return (double)a / b;
}

int main()
{
    int a = 5;
    int b = 0;
    try
    {
        cout << division(a, b) << endl;
    }
    catch (const char *msg)
    {
        cout << msg << endl;
    }
}