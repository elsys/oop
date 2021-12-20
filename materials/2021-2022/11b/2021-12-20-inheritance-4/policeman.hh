#pragma once

#include "base.hh"

// Note: These should all be in different .hh and .cc files
// They're all in the same place to save some space and time

// Base policeman class. We don't really need it, but it helps make inheritance more obvious
class Policeman : public Base {
public:
  Policeman(
    unsigned int hp,
    unsigned int def,
    unsigned int atk
  );
};

class Enforcer : public Policeman {
public:
  Enforcer(
    unsigned int hp,
    unsigned int def,
    unsigned int atk
  );

  void attack(Base& other);
};

class Swat : public Policeman {
  unsigned int maxHp;
public:
  Swat(
    unsigned int hp,
    unsigned int def,
    unsigned int atk
  );

  void attack(Base& other);
};
