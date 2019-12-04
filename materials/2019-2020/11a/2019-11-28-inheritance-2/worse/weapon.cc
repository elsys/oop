#include "./weapon.hh"

Weapon::Weapon(int damage) : damage(damage) {};

void Weapon::attack(Character& target) {
  target.health -= damage;
}
