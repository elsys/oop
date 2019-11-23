#ifndef ANIMAL_HH
#define ANIMAL_HH

#include "./npc.hh"

class Animal : public NPC {
protected:
  int canFly;
  int canSwim;
  int canWalk;
};


#endif
