#pragma once

#include <stdexcept>

template <class T>
class Stack
{
    static const unsigned int chunk = 2;
    int size;
    T *data;
    int top;
    void resize();

public:
    Stack();
    Stack(const Stack &other);
    ~Stack();
    Stack &operator=(const Stack &other);
    T pop();
    void push(const T &value);
};

template class Stack<int>;
//template class Stack<float>;