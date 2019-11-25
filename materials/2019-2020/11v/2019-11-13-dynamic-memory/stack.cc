#include <iostream>

class Stack {
  int* elements;
  int size;
  int capacity;

public:
  class StackEmptyError {};

  Stack()
    : elements(new int[8]),
      size(0),
      capacity(8) {}

  Stack(Stack const& other)
    : elements(new int[other.capacity]),
      capacity(other.capacity),
      size(other.size) {
    for (int i = 0; i < other.size; ++i) {
      elements[i] = other.elements[i];
    }
  }

  Stack& operator=(Stack const& other) {
    if (this == &other) {
      return *this;
    }

    elements = new int[other.capacity];
    size = other.size;
    capacity = other.capacity;

    for (int i = 0; i < other.size; ++i) {
      elements[i] = other.elements[i];
    }

    return *this;
  }

  ~Stack() {
    delete[] elements;
  }

  bool is_empty() const {
    return size == 0;
  }

  int peek() const {
    if (is_empty()) {
      throw StackEmptyError();
    }

    return elements[size - 1];
  }

  void push(int element) {
    if (size == capacity) {
      capacity *= 2;
      int* new_elements = new int[capacity];
      for (int i = 0; i < size; ++i) {
        new_elements[i] = elements[i];
      }
      delete[] elements;
      elements = new_elements;
    }

    elements[size++] = element;
  }

  int pop() {
    if (is_empty()) {
      throw StackEmptyError();
    }

    int result = peek();
    --size;
    return result;
  }
};

int main() {
  Stack* s = new Stack;
  s->push(1);
  s->push(2);

  if (true) {
    Stack s1;
    s1 = *s;

    s1 = s1;

    std::cout << s1.peek() << '\n';
    std::cout << s->peek() << '\n';
  }

  std::cout << s->peek() << '\n';

  delete s;

  return 0;
}
