// Note: Implemented here to save on the number of files
#pragma once

#include <algorithm>

#include "pokemon.hh"
#include "skill.hh"
#include "status_armor_down.hh"

class SkillLeer : public Skill {
public:
  SkillLeer() : Skill("Leer") {}

  void apply(Pokemon& self, Pokemon& opponent) {
    Skill::apply(self, opponent, new StatusArmorDown(3));
  }
};
