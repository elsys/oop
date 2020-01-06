#include "range.hh"
#include <iostream>

Range::Range(int start, int end, int step)
  : start(start), end(end), step(step) {}

int Range::get(unsigned int i) const {
  return start + i * step;
}

int Range::sum() const {
  int result = 0;
  for (int i = start; i <= end; i += step) {
    result += i;
  }
  return result;
}

int Range::product() const {
  int result = 1;
  for (int i = start; i <= end; i += step) {
    result *= i;
  }
  return result;
}

void Range::print() const {
  for (int i = start; i <= end; i += step) {
    std::cout << i;
    if (i + step <= end) {
      std::cout << ", ";
    }
  }
  std::cout << '\n';
}
