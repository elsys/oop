// Note: Implemented here to save on the number of files
#pragma once

#include <algorithm>

#include "status_effect.hh"
#include "pokemon.hh"

class StatusArmorUp : public StatusEffect {
public:
  StatusArmorUp(int duration) : StatusEffect("ArmorUp", duration) {}

  void apply(Pokemon& self, Pokemon& opponent) {
    StatusEffect::apply(self);
    opponent.addDef(20);
  }

  void update(Pokemon& self) {
    StatusEffect::update(self);
    // Restore original def
    if(duration <= 0)
      self.addDef(-20);
  }
};
