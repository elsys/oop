#include <iostream>

#include "base.hh"

using namespace std;

Base::Base(
  unsigned int hp,
  unsigned int def,
  unsigned int atk
) : hp(hp), def(def), atk(atk) {
  cout << "Base::Base" << endl;
}

// Default implementation of the birtual method
void Base::attack(Base& other) {
  cout << "Base::attack" << endl;

  int damage = atk - other.def;
  if(damage <= 0) damage = 1;
  cout << "\tHit for " << damage << endl;

  other.takeDamage(damage);
}

// Default implementation of the birtual method
void Base::takeDamage(unsigned int dmg) {
  cout << "Base::takeDamage" << endl;

  // Avoid unsigned int underflow wrapping
  if(dmg >= hp) hp = 0;
  else hp -= dmg;

  cout << "\tHP left " << hp << endl;
}

int Base::isAlive() {
  cout << "Base::isAlive" << endl;
  return hp > 0;
}

unsigned int Base::getDef() {
  return def;
}
