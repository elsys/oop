// Note: Implemented here to save on the number of files
#pragma once

#include <algorithm>

#include "skill.hh"

class SkillPound : public Skill {
public:
  SkillPound() : Skill("Pound") {}

  void apply(Pokemon& self, Pokemon& opponent) {
    // Add a negative number to the opponent's HP to reduce it
    // Add 0 if opponent's def is too high
    opponent.addHp(std::min(0, -(self.getAtk() - opponent.getDef() + 10)));
  }
};
