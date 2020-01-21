#include "yes_no_question.hh"
#include <iostream>

YesNoQuestion::YesNoQuestion(
    std::string const& text, double points, bool isYes)
  : Question(text, points), isYes(isYes), answer(true) {}

Question* YesNoQuestion::clone() const {
  return new YesNoQuestion(*this);
}

void YesNoQuestion::ask() {
    std::cout << get_text() << '\n';

    std::string answer_text;
    std::cin >> answer_text;

    if (answer_text == "yes") {
      answer = true;
  } else {
    answer = false;
  }
}

double YesNoQuestion::grade() {
  if (isYes == answer) {
    return get_points();
  }
  return 0;
}
