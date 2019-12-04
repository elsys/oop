#ifndef STABBY_HH
#define STABBY_HH

#include "./weapon.hh"

class Stabby : public Weapon {
public:
  int meleRange;
  Stabby(int damage, int meleRange);
  void attack(Character& target);
};

#endif
