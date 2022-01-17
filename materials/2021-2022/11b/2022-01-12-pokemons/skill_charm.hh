// Note: Implemented here to save on the number of files
#pragma once

#include <algorithm>

#include "pokemon.hh"
#include "skill.hh"
#include "status_power_down.hh"

class SkillCharm : public Skill {
public:
  SkillCharm() : Skill("Charm") {}

  void apply(Pokemon& self, Pokemon& opponent) {
    StatusPowerDown spd;
    spd.apply(opponent);
  }
};
