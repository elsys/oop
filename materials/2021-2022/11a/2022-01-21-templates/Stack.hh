#ifndef _STACK_HH_
#define _STACK_HH_

#include <iostream>

using namespace std;

template <class T> class Stack {
  const static unsigned int chunk = 2;
  int size;
  T *data;
  int top;
  void resize();

public:
  Stack();

  ~Stack();

  Stack(const Stack &other);

  Stack &operator=(const Stack &other);

  void push(const T &v);

  T pop();
};

#endif