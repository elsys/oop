// Note: Implemented here to save on the number of files
#pragma once

#include <algorithm>

#include "pokemon.hh"
#include "skill.hh"
#include "status_hp_steal.hh"

class SkillLeechSeed : public Skill {
public:
  SkillLeechSeed() : Skill("LeechSeed") {}

  void apply(Pokemon& self, Pokemon& opponent) {
    Skill::apply(self, opponent, new StatusHPSteal(3));
  }
};
