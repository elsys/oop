#ifndef ACTION_HH
#define ACTION_HH

#include <vector>
#include <string>

class Action {
  unsigned int number;
  std::vector<std::string> actors;

public:
  Action(unsigned int number, std::vector<std::string> const& actors);

  unsigned int get_number() const;

  std::vector<std::string> const& get_actors() const;

  virtual Action* clone() const;

  virtual void print() const;
};

#endif
