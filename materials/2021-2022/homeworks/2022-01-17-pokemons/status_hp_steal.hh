// Note: Implemented here to save on the number of files
#pragma once

#include <algorithm>

#include "status_effect.hh"
#include "pokemon.hh"

class StatusHPSteal : public StatusEffect {
  Pokemon* opponent;
public:
  StatusHPSteal(int duration) : StatusEffect("HPSteal", duration) {}

  void apply(Pokemon& self, Pokemon& opponent) {
    StatusEffect::apply(self);
    this->opponent = &opponent;
  }

  void update(Pokemon& self) {
    StatusEffect::update(self);
    // Steal HP from the opponent
    if(duration > 0) {
      // This check is just to avoid an incorrect number in the message
      int stolen = min(5, opponent->getHp());
      opponent->addHp(-stolen);
      self.addHp(2);

      cout << self.getName() << " stole " << 2 << " HP from " << opponent->getName() << endl;
    }
  }
};
