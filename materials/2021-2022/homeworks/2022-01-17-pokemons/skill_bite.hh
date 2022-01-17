// Note: Implemented here to save on the number of files
#pragma once

#include <algorithm>

#include "pokemon.hh"
#include "skill.hh"

class SkillBite : public Skill {
public:
  SkillBite() : Skill("Bite") {}

  void apply(Pokemon& self, Pokemon& opponent) {
    // Add a negative number to the opponent's HP to reduce it
    // Add 0 if opponent's def is too high
    opponent.addHp(std::min(0, -(15 - opponent.getDef())));
  }
};
