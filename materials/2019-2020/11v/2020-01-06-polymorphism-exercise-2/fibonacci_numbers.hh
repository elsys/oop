#ifndef FIBONACCI_NUMBERS_HH
#define FIBONACCI_NUMBERS_HH

#include "sequence.hh"

class FibonacciNumbers : public Sequence {
  unsigned int n;

public:
  FibonacciNumbers(unsigned int n);

  int get(unsigned int i) const;

  int sum() const;

  int product() const;

  void print() const;
}

#endif

