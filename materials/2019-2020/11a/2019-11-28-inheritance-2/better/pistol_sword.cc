#include "./pistol_sword.hh"

PistolSword::PistolSword(int damage, int minRange, int maxRange, int meleRange) : Weapon(damage), Shooty(minRange, maxRange), Stabby(meleRange) {};

void PistolSword::attack(Character& target) {
  float distance = distanceTo(target);

  if(distance >= minRange && distance <= maxRange || distance <= meleRange) {
    target.health -= damage;
  }
}
