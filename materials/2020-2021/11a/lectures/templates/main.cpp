#include "stack.h"
#include <iostream>

using namespace std;

int main()
{
    Stack<int> stack;
    for (int i = 0; i < 10; i++)
    {
        stack.push(i);
    }

    for (int i = 0; i < 11; i++)
    {
        cout << stack.pop() << endl;
    }
}