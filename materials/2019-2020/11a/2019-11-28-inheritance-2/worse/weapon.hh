#ifndef WEAPON_HH
#define WEAPON_HH

#include "./solid_object.hh"
#include "./character.hh"

class Weapon : public SolidObject {
public:
  int damage;
  Weapon(int damage);
  void attack(Character& target);
};

#endif
