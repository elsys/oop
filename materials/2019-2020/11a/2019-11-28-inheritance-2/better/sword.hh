#ifndef SWORD_HH
#define SWORD_HH

#include "./weapon.hh"
#include "./stabby.hh"

class Sword : public Weapon, public Stabby {
public:
  Sword(int damage, int meleRange);

  void attack(Character& target);
};

#endif
