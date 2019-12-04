#ifndef PISTOL_HH
#define PISTOL_HH

#include "./shooty.hh"

class Pistol : public Shooty {
public:
  Pistol(int damage, int minRange, int maxRange);
};

#endif
