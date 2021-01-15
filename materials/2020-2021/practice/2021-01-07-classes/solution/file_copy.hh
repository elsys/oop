#ifndef FILE_COPY_HH
#define FILE_COPY_HH

#include "process.hh"

class file_copy : public process {
  int file_count;
  int copy_speed;
public:
  file_copy(int file_count, int copy_speed);

  int get_time();

  int get_priority();

  void print();
};

#endif
