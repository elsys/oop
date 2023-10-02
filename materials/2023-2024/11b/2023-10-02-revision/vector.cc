#include <iostream>
#include "vector.hh"
#include "string.h"

using namespace std;

Vector::Vector() {
    count = 0;
    capacity = 0;
    arr = nullptr;
}

Vector::~Vector() {
    clear();
}

void Vector::resize() {
    cout << "Vector::resize from " << capacity << endl;
    if(capacity == 0)
        capacity = 1;
    else
        capacity *= 2;

    int* tmp = new int[capacity];

    // for(int i = 0; i < size; i++) 
    //     tmp[i] = arr[i];
    memcpy(tmp, arr, sizeof(int) * count);

    delete[] arr;
    arr = tmp;
}

void Vector::push(int value) {
    if(count >= capacity) {
        resize();
    }

    arr[count++] = value;
}

int Vector::pop() {
    int res = arr[count-1];

    arr[--count] = 0;

    return res;
}

int Vector::size() {
    return this->count;
}

void Vector::clear() {
    count = 0;
    capacity = 0;
    delete[] arr;
    arr = nullptr;
}
