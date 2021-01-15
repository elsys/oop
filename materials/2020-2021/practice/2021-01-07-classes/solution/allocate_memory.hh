#ifndef ALLOCATE_MEMORY_HH
#define ALLOCATE_MEMORY_HH

#include "process.hh"

class allocate_memory : public process {
  int required_size;
  int total_size;

  int first_rand;
  int second_rand;
public:
  allocate_memory(int required_size, int total_size);

  int get_time();

  int get_priority();

  void print();
};

#endif
