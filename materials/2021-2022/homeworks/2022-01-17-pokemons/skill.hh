#pragma once
#include <string>

using namespace std;

class Pokemon;
class StatusEffect;

class Skill {
protected:
  string name;
  // Helper method to save a couple of lines
  void apply(Pokemon& self, Pokemon& opponent, StatusEffect* effect);
public:
  Skill(string name);

  // Abstract method to be implemented by children
  virtual void apply(Pokemon& self, Pokemon& opponent) = 0;

  string getName() const;
};
