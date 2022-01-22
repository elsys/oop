#include "Stack.hh"
#include <iostream>

using namespace std;
template <class T> void Stack<T>::resize() {
  T *oldData = data;
  data = new T[size + chunk];
  for (int i = 0; i < size; i++) {
    data[i] = oldData[i];
  }
  delete[] oldData;
  size += chunk;
}

template <class T> Stack<T>::Stack() {
  size = chunk;
  data = new T(size);
  top = -1;
}

template <class T> Stack<T>::~Stack() { delete[] data; }

template <class T> Stack<T>::Stack(const Stack &other) {
  size = other.size;
  data = new T[size];
  top = other.top;

  for (int i = 0; i <= top; i++) {
    data[i] = other.data[i];
  }
}

template <class T> Stack<T> &Stack<T>::operator=(const Stack &other) {
  if (this != &other) {
    delete[] data;
    size = other.size;
    top = other.top;
    data = new T[size];
    for (int i = 0; i <= top; i++) {
      data[i] = other.data[i];
    }
  }
}

template <class T> void Stack<T>::push(const T &v) {
  if (top >= (size - 1)) {
    resize();
  }
  data[++top] = v;
}

template <class T> T Stack<T>::pop() {
  if (top < 0) {
    throw exception();
  }
  return data[top--];
}