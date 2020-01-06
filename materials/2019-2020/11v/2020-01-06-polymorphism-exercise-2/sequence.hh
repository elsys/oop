#ifndef SEQUENCE_HH
#define SEQUENCE_HH

class Sequence {
public:
  virtual int get(unsigned int i) const = 0;

  virtual int sum() const = 0;

  virtual int product() const = 0;

  virtual void print() const = 0;
};

#endif
