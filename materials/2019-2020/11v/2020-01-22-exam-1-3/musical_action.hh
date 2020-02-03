#ifndef MUSICAL_ACTION_HH
#define MUSICAL_ACTION_HH

#include "action.hh"
#include <string>

class MusicalAction : public Action {
  std::string song;

public:
  MusicalAction(
      unsigned int number,
      std::vector<std::string> const& actors,
      std::string const& song);

  Action* clone() const;

  void print() const;
};

#endif
