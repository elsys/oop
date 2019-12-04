#ifndef SWORD_HH
#define SWORD_HH

#include "./stabby.hh"

class Sword : public Stabby {
public:
  Sword(int damage, int meleRange);
};

#endif
