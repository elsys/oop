#include "action.hh"
#include <iostream>

Action::Action(unsigned int number, std::vector<std::string> const& actors)
  : number(number), actors(actors) {}

unsigned int Action::get_number() const {
  return number;
}

std::vector<std::string> const& Action::get_actors() const {
  return actors;
}

Action* Action::clone() const {
  return new Action(*this);
}

void Action::print() const {
  std::cout << number;
  if (!actors.empty()) {
    std::cout << '\n';
  }
  for (auto iter = actors.begin(); iter != actors.end(); ++iter) {
    std::cout << *iter;
    if (iter + 1 != actors.end()) {
      std::cout << ", ";
    }
  }
}
