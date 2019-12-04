#include "./sword.hh"

Sword::Sword(int damage, int meleRange) : Weapon(damage), Stabby(meleRange) {};

void Sword::attack(Character& target) {
  float distance = distanceTo(target);

  if(distance <= meleRange) {
    target.health -= damage;
  }
}
