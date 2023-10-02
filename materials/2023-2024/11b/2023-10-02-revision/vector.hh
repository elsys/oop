#pragma once

#include "collection.hh"

class Vector : public Collection {
    unsigned int count;
    unsigned int capacity;
    int* arr;

    void resize();
public:
    Vector();
    ~Vector();

    void push(int value);
    int pop();
    int size();
    void clear();
};