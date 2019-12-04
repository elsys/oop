#include "./stabby.hh"

Stabby::Stabby(int damage, int meleRange) : Weapon(damage), meleRange(meleRange) {}

void Stabby::attack(Character& target) {
  float distance = distanceTo(target);

  if(distance <= meleRange) {
    target.health -= damage;
  }
}
