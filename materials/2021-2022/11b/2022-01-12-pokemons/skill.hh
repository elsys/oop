#pragma once
#include <string>

using namespace std;

class Pokemon;

class Skill {
  string name;
public:
  Skill(string name);

  // Abstract method to be implemented by children
  virtual void apply(Pokemon& self, Pokemon& opponent) = 0;

  string getName() const;
};
