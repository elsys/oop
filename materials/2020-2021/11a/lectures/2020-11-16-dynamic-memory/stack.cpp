#include <iostream>
#include <exception>
using namespace std;

class Stack
{
    const static int chunk = 2;
    int size;
    int *data;
    int top;

    void resize()
    {
        cout << "Stack resize is called" << endl;
        int *temp = data;
        data = new int[size + chunk];
        for (int i = 0; i < size; i++)
        {
            data[i] = temp[i];
        }
        delete temp;
        size += chunk;
        cout << "New stack size: " << size << endl;
    }

public:
    Stack()
    {
        top = -1;
        size = chunk;
        data = new int[size];
    }

    ~Stack()
    {
        delete[] data;
    }

    void push(int value)
    {
        if (top >= size - 1)
        {
            resize();
        }

        data[++top] = value;
    }

    int pop()
    {
        if (top < 0)
        {
            throw exception();
        }
        return data[top--];
    }
};

void m()
{
    Stack s;
    s.push(1);
}

int main()
{

    m();
    Stack st;

    try
    {
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
    }
    catch (const exception &ex)
    {
        cout << "exception catched" << endl;
    }

    try
    {
        cout << st.pop() << endl;
        cout << st.pop() << endl;
        cout << st.pop() << endl;
    }
    catch (const exception &ex)
    {
        cout << "exception catched when pop" << endl;
    }

    delete &st;
}