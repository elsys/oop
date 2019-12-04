#ifndef SHOOTY_HH
#define SHOOTY_HH

#include "./weapon.hh"

class Shooty : public Weapon {
public:
  int minRange;
  int maxRange;
  int ammo;
  void attack(Character& target);
  Shooty(int damage, int minRange, int maxRange);
};

#endif
