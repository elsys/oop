#ifndef AI_CHARACTER_HH
#define AI_CHARACTER_HH

#include "./npc.hh"

class AiCharacter : public NPC {
public:
  int canCallReinforcements;
  int isAggressive;
};


#endif
