// Note: Implemented here to save on the number of files
#pragma once

#include <algorithm>

#include "status_effect.hh"
#include "pokemon.hh"

class StatusPowerDown : public StatusEffect {
public:
  StatusPowerDown(int duration) : StatusEffect("PowerDown", duration) {}

  void apply(Pokemon& self, Pokemon& opponent) {
    StatusEffect::apply(opponent);
    opponent.addAtk(-10);
  }

  void update(Pokemon& self) {
    StatusEffect::update(self);
    // Restore original def
    if(duration <= 0)
      self.addAtk(10);
  }
};
