#include <iostream>
#include <exception>
using namespace std;

class Stack
{
    const static int chunk = 2;
    int *data;
    int top;
    int size;

    void resize()
    {
        cout << "Stack is being resized" << endl;
        int *temp = data;
        data = new int[size + chunk];
        for (int i = 0; i < size; i++)
        {
            data[i] = temp[i];
        }
        delete[] temp;
        size += chunk;
        cout << "Stack is resized. New size: " << size << endl;
    }

public:
    Stack()
    {
        size = chunk;
        top = -1;
        data = new int[size];
    }

    void push(int v)
    {
        if (top >= size - 1)
        {
            resize();
        }
        data[++top] = v;
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

int main()
{
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
        cout << "Exception catched when pushing." << endl;
    }

    try
    {
        cout << st.pop() << endl;
        cout << st.pop() << endl;
        cout << st.pop() << endl;
    }
    catch (const exception &ex)
    {
        cout << "Exception catched when poping." << endl;
    }
}