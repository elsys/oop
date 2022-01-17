// Note: Implemented here to save on the number of files
#pragma once

#include <algorithm>

#include "pokemon.hh"
#include "skill.hh"
#include "status_power_up.hh"

class SkillMeditate : public Skill {
public:
  SkillMeditate() : Skill("Meditate") {}

  void apply(Pokemon& self, Pokemon& opponent) {
    StatusPowerUp spu;
    spu.apply(self);
  }
};
