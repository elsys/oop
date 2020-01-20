#ifndef TEST_HH
#define TEST_HH

#include "question.hh"
#include <vector>

class Test {
  std::vector<Question*> questions;

public:
  Test();

  Test(Test const& other);

  Test& operator=(Test const& other);

  ~Test();

  void add_question(Question const* question);

  void do_test();

  double grade_test();
};

#endif
