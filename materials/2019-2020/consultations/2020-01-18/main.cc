#include "yes_no_question.hh"
#include "multiple_choice.hh"
#include "open_question.hh"
#include "test.hh"
#include <iostream>

int main() {
  YesNoQuestion ynq("text", 10, true);

  YesNoQuestion* ynq2 = new YesNoQuestion("text", 10, true);

  Test t;
  t.add_question(&ynq);
  t.add_question(ynq2);

  delete ynq2;

  t.do_test();
  std::cout << t.grade_test() << '\n';

  return 0;
}
