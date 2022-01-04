#include <iostream>

#include "base.hh"
#include "policeman.hh"

using namespace std;

Policeman::Policeman(
  unsigned int hp,
  unsigned int def,
  unsigned int atk
) : Base(hp, def, atk) {
  cout << "Policeman::Policeman" << endl;
}

Enforcer::Enforcer(
  unsigned int hp,
  unsigned int def,
  unsigned int atk
) : Policeman(hp, def, atk) {
  cout << "Enforcer::Enforcer" << endl;
}

void Enforcer::attack(Base& other) {
  cout << "Enforcer::attack" << endl;

  Base::attack(other);
  if(!other.isAlive()) return;

  Base::attack(other);
}

Swat::Swat(
  unsigned int hp,
  unsigned int def,
  unsigned int atk
) : Policeman(hp, def, atk), maxHp(hp) {
  cout << "Swat::Swat" << endl;
}

void Swat::attack(Base& other) {
  cout << "Swat::attack" << endl;

  // Attack and ignore 15% of defence with a minimum of 1
  // Note: other.dmg is inaccessible because it's a different class from Swat
  int damage = atk - (other.getDef() * 0.85);
  if(damage <= 0) damage = 1;

  cout << "\tHit for " << damage << endl;
  other.takeDamage(damage);

  // Restore 5% health up to the max
  cout << "\tHeal for " << maxHp * 0.05 << endl;
  hp += maxHp * 0.05;
  if(hp > maxHp)
    hp = maxHp;
}
