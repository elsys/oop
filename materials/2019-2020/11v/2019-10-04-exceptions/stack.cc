#include <iostream>

using namespace std;

const int CAPACITY = 100;

class StackEmptyError {};
class StackFullError {};

class Stack {
  int size;
  int elements[CAPACITY];

  bool is_full() {
    return size == CAPACITY;
  }

public:
  Stack() {
    size = 0;
  }

  bool is_empty() {
    return size == 0;
  }

  int peek() {
    if (is_empty()) {
      throw StackEmptyError();
    }
    return elements[size - 1];
  }

  void push(int element) {
    if (is_full()) {
      throw StackFullError();
    }
    elements[size++] = element;
  }

  void pop() {
    if (is_empty()) {
      throw StackEmptyError();
    }
    --size;
  }
};

int main() {
  Stack stack;
  try {
    cout << stack.is_empty() << '\n';
    stack.push(42);
    cout << stack.is_empty() << '\n';
    stack.push(123);
    cout << stack.peek() << '\n';
    stack.pop();
    cout << stack.peek() << '\n';
    stack.pop();
    cout << stack.is_empty() << '\n';
    stack.pop();
  } catch(StackEmptyError error) {
    cout << "Error: stack is empty\n";
  } catch(StackFullError error) {
    cout << "Error: stack is full\n";
  } catch(...) {
    cout << "An error occurred\n";
  }

  return 0;
}
