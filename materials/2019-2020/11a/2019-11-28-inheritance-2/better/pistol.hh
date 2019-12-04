#ifndef PISTOL_HH
#define PISTOL_HH

#include "./shooty.hh"
#include "./weapon.hh"

class Pistol : public Weapon, public Shooty {
public:
  Pistol(int damage, int minRange, int maxRange);

  void attack(Character& target);
};

#endif
