#pragma once
#include <string>

using namespace std;

class Pokemon;

class StatusEffect {
  string name;
public:
  StatusEffect(string name);

  // Abstract method to be implemented by children
  virtual void apply(Pokemon& target) = 0;
};
