#ifndef NPC_HH
#define NPC_HH

#include <string>
using namespace std;

#include "./character.hh"

class NPC : public Character {
protected:
  string job;
};

#endif
