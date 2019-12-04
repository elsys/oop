#ifndef CHARACTER_HH
#define CHARACTER_HH

#include "./solid_object.hh"

class Character : public SolidObject {
public:
  int money;
  int health;
};

#endif
