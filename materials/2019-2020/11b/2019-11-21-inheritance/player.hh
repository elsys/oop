#ifndef PLAYER_HH
#define PLAYER_HH

#include <string>
using namespace std;

#include "./character.hh"

class Player : public Character {
public:
  string name;
};

#endif
