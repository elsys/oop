#include "skill.hh"
#include "status_effect.hh"

Skill::Skill(string name) : name(name) {}

void Skill::apply(Pokemon& self, Pokemon& opponent, StatusEffect* effect) {
  effect->apply(self, opponent);
}

string Skill::getName() const {
  return name;
}
