#ifndef RANGE_HH
#define RANGE_HH

#include "sequence.hh"

class Range : public Sequence {
public:
  Range(int start, int end, int step);

  int get(unsigned int i) const;

  int sum() const;

  int product() const;

  void print() const;
}

#endif
