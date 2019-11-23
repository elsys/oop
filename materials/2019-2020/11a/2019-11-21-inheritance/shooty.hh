#ifndef SHOOTY_HH
#define SHOOTY_HH

#include "./weapon.hh"

class Shooty : public Weapon {
protected:
  int fireSpeed;
  int magazineSize;
  int range;
};

#endif
