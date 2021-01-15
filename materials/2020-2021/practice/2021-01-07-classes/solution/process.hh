#ifndef PROCESS_HH
#define PROCESS_HH

class process {
  int importance;
public:
  process(int importance);

  int get_importance();

  virtual int get_time() = 0;

  virtual int get_priority() = 0;

  virtual void print() = 0;
};

#endif
