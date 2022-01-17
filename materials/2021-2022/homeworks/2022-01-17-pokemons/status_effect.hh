#pragma once
#include <string>

using namespace std;

class Pokemon;

class StatusEffect {
protected:
  string name;
  int duration = 0;
  void apply(Pokemon& target);
public:
  StatusEffect(string name);
  StatusEffect(string name, int duration);

  // Abstract methods to be implemented by children
  virtual void apply(Pokemon& self, Pokemon& opponent) = 0;
  virtual void update(Pokemon& self);

  string getName() const;
  int getDuration() const;
};
