#ifndef PISTOL_SWORD_HH
#define PISTOL_SWORD_HH

#include "./weapon.hh"
#include "./shooty.hh"
#include "./stabby.hh"

class PistolSword : public Weapon, public Shooty, public Stabby {
public:
  PistolSword(int damage, int minRange, int maxRange, int meleRange);

  void attack(Character& target);
};

#endif
