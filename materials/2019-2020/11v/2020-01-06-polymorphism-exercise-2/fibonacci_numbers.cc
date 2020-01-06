#include "fibonacci_numbers.hh"

FibonacciNumbers::FibonacciNumbers(unsigned int n): n(n) {}

int FibonacciNumbers::get(unsigned int i) const {
  int current = 0;
  int next = 1;
  for (int j = 0; j < i; ++j) {
    int new_current = next;
    next = current + next;
    current = new_current;
  }
  return current;
}

int FibonacciNumbers::sum() const {
  int result = 0;
  int current = 0;
  int next = 1;
  for (int j = 0; j < i; ++j) {
    result += current;
    int new_current = next;
    next = current + next;
    current = new_current;
  }
  return result;
}

int FibonacciNumbers::product() const {
  return 0;
}

void FibonacciNumbers::print() const {
  int current = 0;
  int next = 1;
  for (int i = 0; i < n; ++i) {
    std::cout << current;
    if (i + 1 < n) {
      std::cout << ", ";
    }
    int new_current = next;
    next = current + next;
    current = new_current;
  }
  std::cout << '\n';
}
