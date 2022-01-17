#pragma once
#include <string>
#include <vector>

using namespace std;

class Skill;
class StatusEffect;

class Pokemon {
  string name;
  int maxHp;
  int currHp;
  int atk;
  int def;
  // Array of 4 pointers
  Skill* skills[4];
  vector<StatusEffect*> activeEffects;
public:
  Pokemon(string name, int maxHp, int atk, int def, Skill* skills[4]);

  void useSkill(Pokemon& opponent, unsigned short skillIndex);

  int getAtk() const;
  int getDef() const;
  int getHp() const;
  string getName() const;

  void addHp(int toAdd);
  void addAtk(int toAdd);
  void addDef(int toAdd);
  void addEffect(StatusEffect* toAdd);
  void removeEffect(StatusEffect* toRemove);
};
