#pragma once

#include "base.hh"

// Note: These should all be in different .hh and .cc files
// They're all in the same place to save some space and time

// Base mafioso class. We don't really need it, but it helps make inheritance more obvious
class Mafioso : public Base {
public:
  Mafioso(
    unsigned int hp,
    unsigned int def,
    unsigned int atk
  );
};

class ToughGuy : public Mafioso {
public:
  ToughGuy(
    unsigned int hp,
    unsigned int def,
    unsigned int atk
  );

  // We need to reduce the received damage
  void takeDamage(unsigned int dmg);
};

class Specialist : public Mafioso {
  unsigned int grenadeAtk;
public:
  Specialist(
    unsigned int hp,
    unsigned int def,
    unsigned int atk,
    unsigned int grenadeAtk
  );

  // Has a special attack
  void attack(Base& other);
};
