#ifndef CHARACTER_HH
#define CHARACTER_HH

#include "./entity.hh"
//#include "./weapon.hh"

class Character : public Entity {
protected:
//  Weapon activeWeapon;
  int money;
  int health;
};

#endif
