#include "multiple_choice.hh"
#include <iostream>

MultipleChoice::MultipleChoice(
    std::string const& text,
    double points,
    std::vector<std::string> const& answers,
    std::vector<unsigned int> const& true_answers)
  : Question(text, points), answers(answers), true_answers(true_answers) {}

Question* MultipleChoice::clone() const {
  return new MultipleChoice(*this);
}

void MultipleChoice::ask() {
  std::cout << get_text() << '\n';
  unsigned int index = 0;
  for (auto iter = answers.begin();
      iter != answers.end();
      ++index, ++iter) {
    std::cout << index << ". " << *iter << '\n';
  }

  unsigned int current_answer = 0;
  while (std::cin >> current_answer) {
    user_answers.push_back(current_answer);
  }
}

double MultipleChoice::grade() {
  double result = 0;
  for (auto iter = user_answers.begin();
      iter != user_answers.end();
      ++iter) {
    bool is_true_found = false;
    for (auto true_iter = true_answers.begin();
        true_iter != true_answers.end();
        ++true_iter) {
      if (*iter == *true_iter) {
        result += get_points();
        is_true_found = true;
        break;
      }
    }
    if (!is_true_found) {
      result -= get_points();
    }
  }
  return result;
}
