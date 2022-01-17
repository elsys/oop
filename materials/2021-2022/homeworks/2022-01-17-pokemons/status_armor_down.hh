// Note: Implemented here to save on the number of files
#pragma once

#include <algorithm>

#include "status_effect.hh"
#include "pokemon.hh"

class StatusArmorDown : public StatusEffect {
public:
  StatusArmorDown(int duration) : StatusEffect("ArmorDown", duration) {}

  void apply(Pokemon& self, Pokemon& opponent) {
    StatusEffect::apply(opponent);
    opponent.addDef(-15);
  }

  void update(Pokemon& self) {
    StatusEffect::update(self);
    // Restore original def
    if(duration <= 0)
      self.addDef(15);
  }
};
