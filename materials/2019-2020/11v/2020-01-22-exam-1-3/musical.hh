#ifndef MUSICAL_ACTION_HH
#define MUSICAL_ACTION_HH

#include "action.hh"
#include <string>
#include <vector>

class Musical {
  std::string title;
  std::vector<Action*> actions;

  std::vector<Action*>::const_iterator find_action(unsigned int number) const;

  bool has_missing_actions() const;

public:
  class NoActionsError {};

  class ActionAlreadyExistsError {};

  class MissingActionsError {};

  Musical(std::string const& title);

  Musical(Musical const& other);

  Musical& operator=(Musical const& other);

  ~Musical();

  void add_action(Action const* action);

  void print() const;

  Action const* most_crowded_action() const;

  void sort();
};

#endif
