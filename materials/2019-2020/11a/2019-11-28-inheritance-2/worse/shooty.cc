#include "./shooty.hh"

Shooty::Shooty(int damage, int minRange, int maxRange) : Weapon(damage), minRange(minRange), maxRange(maxRange) {};

void Shooty::attack(Character& target) {
  float distance = distanceTo(target);

  if(distance >= minRange && distance <= maxRange) {
    target.health -= damage;
  }
}
