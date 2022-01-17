// Note: Implemented here to save on the number of files
#pragma once

#include <algorithm>

#include "status_effect.hh"
#include "pokemon.hh"

class StatusPowerUp : public StatusEffect {
public:
  StatusPowerUp() : StatusEffect("PowerUp") {}

  void apply(Pokemon& target) {
    target.addAtk(15);
  }
};
