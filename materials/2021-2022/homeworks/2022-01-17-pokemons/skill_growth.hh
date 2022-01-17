// Note: Implemented here to save on the number of files
#pragma once

#include <algorithm>

#include "pokemon.hh"
#include "skill.hh"
#include "status_power_up.hh"

class SkillGrowth : public Skill {
public:
  SkillGrowth() : Skill("Growth") {}

  void apply(Pokemon& self, Pokemon& opponent) {
    Skill::apply(self, opponent, new StatusPowerUp(3));
  }
};
