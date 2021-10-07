#include <iostream>
using namespace std;

class StackException
{
    const char *message;

public:
    StackException(const char *message)
    {
        this->message = message;
    }
    const char *what()
    {
        return message;
    }
};

class Stack
{
private:
    const int STACK_SIZE = 10;
    int data[10];
    int top;

public:
    Stack()
    {
        top = 0;
    }

    int element()
    {
        return data[top];
    }

    void push(int value)
    {
        if (top >= STACK_SIZE)
        {
            throw 5;
            //throw StackException("Stack is full");
        }
        data[top++] = value;
    }

    int pop()
    {
        if (top < 0)
        {
            //throw StackException("Stack is empty");
            throw "Stack is empty!";
        }
        return data[--top];
    }

    bool isEmpty()
    {
        return top <= 0;
    }

    bool isFull()
    {
        return top >= STACK_SIZE;
    }
};

int main()
{
    Stack st;
    try
    {
        for (int i = 0; i < 10; i++)
        {
            st.push(i);
        }
        for (int i = 0; i < 20; i++)
        {
            cout << "elemene: " << st.pop() << endl;
        }
    }
    catch (StackException ex)
    {
        cout << ex.what() << endl;
    }
    catch (...)
    {
        cout << "Exception happened" << endl;
    }
    // catch (const char *)
    // {
    //     cout << "String error" << endl;
    // }
}