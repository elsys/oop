#include <string>
#include <iostream>
#include "status_effect.hh"
#include "pokemon.hh"

using namespace std;

StatusEffect::StatusEffect(string name) : name(name) {}

StatusEffect::StatusEffect(string name, int duration) : name(name), duration(duration) {}

void StatusEffect::apply(Pokemon& target) {
  target.addEffect(this);
}

void StatusEffect::update(Pokemon& self) {
  if(duration > 0) duration--;
  if(duration <= 0) {
    cout << self.getName() << " removing effect " << name << endl;
    self.removeEffect(this);
  }
}

string StatusEffect::getName() const {
  return name;
}

int StatusEffect::getDuration() const {
  return duration;
}
