#include <iostream>

using namespace std;

const int CAPACITY = 100;

class Stack {
  int size;
  int elements[CAPACITY];

public:
  Stack() {
    size = 0;
  }

  bool is_empty() {
    return size == 0;
  }

  int peek() {
    return elements[size - 1];
  }

  void push(int element) {
    elements[size++] = element;
  }

  void pop() {
    --size;
  }
};

int main() {
  Stack stack;
  cout << stack.is_empty() << '\n';
  stack.push(42);
  cout << stack.is_empty() << '\n';
  stack.push(123);
  cout << stack.peek() << '\n';
  stack.pop();
  cout << stack.peek() << '\n';
  stack.pop();
  cout << stack.is_empty() << '\n';

  return 0;
}
