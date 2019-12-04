#ifndef PISTOL_SWORD_HH
#define PISTOL_SWORD_HH

#include "./shooty.hh"
#include "./stabby.hh"

class PistolSword : public Shooty, public Stabby {
public:
  PistolSword(int damage, int minRange, int maxRange, int meleRange);
};

#endif
