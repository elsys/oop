#ifndef WEAPON_HH
#define WEAPON_HH

#include "./solid_object.hh"

class Weapon : public SolidObject {
protected:
  int damage;
};

#endif
