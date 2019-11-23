#ifndef CHARACTER_HH
#define CHARACTER_HH

#include "./solid_object.hh"
#include "./weapon.hh"

class Character : public SolidObject {
protected:
  Weapon activeWeapon;
  int money;
  int health;
};

#endif
