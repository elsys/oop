#include "./pistol.hh"

Pistol::Pistol(int damage, int minRange, int maxRange) : Weapon(damage), Shooty(minRange, maxRange) {};

void Pistol::attack(Character& target) {
  float distance = distanceTo(target);

  if(distance >= minRange && distance <= maxRange) {
    target.health -= damage;
  }
}
