// Note: Implemented here to save on the number of files
#pragma once

#include <algorithm>

#include "pokemon.hh"
#include "skill.hh"

class SkillHeal : public Skill {
public:
  SkillHeal() : Skill("Heal") {}

  void apply(Pokemon& self, Pokemon& opponent) {
    // Restore HP to self. The method will ensure currHp doesn't go over maxHp
    self.addHp(10);
  }
};
