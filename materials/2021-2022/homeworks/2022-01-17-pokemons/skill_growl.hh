// Note: Implemented here to save on the number of files
#pragma once

#include <algorithm>

#include "pokemon.hh"
#include "skill.hh"
#include "status_power_down.hh"

class SkillGrowl : public Skill {
public:
  SkillGrowl() : Skill("Growl") {}

  void apply(Pokemon& self, Pokemon& opponent) {
    Skill::apply(self, opponent, new StatusPowerDown(4));
  }
};
