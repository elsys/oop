// Note: Implemented here to save on the number of files
#pragma once

#include <algorithm>

#include "status_effect.hh"
#include "pokemon.hh"

class StatusPowerUp : public StatusEffect {
public:
  StatusPowerUp(int duration) : StatusEffect("PowerUp", duration) {}

  void apply(Pokemon& self, Pokemon& opponent) {
    StatusEffect::apply(self);
    self.addAtk(15);
  }

  void update(Pokemon& self) {
    StatusEffect::update(self);
    // Restore original def
    if(duration <= 0)
      self.addAtk(-15);
  }
};
