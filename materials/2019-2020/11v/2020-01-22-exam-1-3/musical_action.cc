#include "musical_action.hh"
#include <iostream>

MusicalAction::MusicalAction(
    unsigned int number,
    std::vector<std::string> const& actors,
    std::string const& song)
  : Action(number, actors), song(song) {}

Action* MusicalAction::clone() const {
  return new MusicalAction(*this);
}

void MusicalAction::print() const {
  Action::print();
  std::cout << '\n' << song;
}
