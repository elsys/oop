// Note: Implemented here to save on the number of files
#pragma once

#include <algorithm>

#include "status_effect.hh"
#include "pokemon.hh"

class StatusPowerDown : public StatusEffect {
public:
  StatusPowerDown() : StatusEffect("PowerDown") {}

  void apply(Pokemon& target) {
    target.addAtk(-10);
  }
};
