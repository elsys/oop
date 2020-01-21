#include "open_question.hh"
#include <iostream>

OpenQuestion::OpenQuestion(std::string const& text, double points)
  : Question(text, points) {}

Question* OpenQuestion::clone() const {
  return new OpenQuestion(*this);
}

void OpenQuestion::ask() {
  std::cout << get_text() << '\n';
  std::cin >> answer;
}

double OpenQuestion::grade() {
  std::cout << get_text() << '\n';
  std::cout << answer << '\n';
  if (answer == "") {
    return 0;
  }

  double percent = 0;
  std::cin >> percent;

  return (percent / 100) * get_points();
}
