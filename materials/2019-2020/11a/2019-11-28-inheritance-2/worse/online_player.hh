#ifndef ONLINE_PLAYER_HH
#define ONLINE_PLAYER_HH

#include <string>
using namespace std;

#include "./character.hh"

class OnlinePlayer : public Character {
public:
  string name;
};


#endif
