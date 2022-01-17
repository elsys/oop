// Note: Implemented here to save on the number of files
#pragma once

#include <algorithm>

#include "pokemon.hh"
#include "skill.hh"
#include "status_armor_up.hh"

class SkillAcidArmor : public Skill {
public:
  SkillAcidArmor() : Skill("AcidArmor") {}

  void apply(Pokemon& self, Pokemon& opponent) {
    Skill::apply(self, opponent, new StatusArmorUp(4));
  }
};
