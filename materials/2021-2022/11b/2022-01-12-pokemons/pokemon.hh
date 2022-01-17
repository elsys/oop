#pragma once
#include <string>

using namespace std;

class Skill;

class Pokemon {
  string name;
  int maxHp;
  int currHp;
  int atk;
  int def;
  // Array of 4 pointers
  Skill* skills[4];
public:
  Pokemon(string name, int maxHp, int atk, int def, Skill* skills[4]);

  void useSkill(Pokemon& opponent, unsigned short skillIndex);

  int getAtk() const;
  int getDef() const;
  int getHp() const;
  string getName() const;

  void addHp(int toAdd);
  void addAtk(int toAdd);
};
