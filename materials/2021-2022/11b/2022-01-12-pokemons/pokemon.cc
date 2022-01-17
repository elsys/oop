#include <iostream>
#include <string>
#include <stdexcept>
#include <algorithm>

#include "pokemon.hh"
#include "skill.hh"

using namespace std;

Pokemon::Pokemon(string name, int maxHp, int atk, int def, Skill* skills[4]) : name(name), maxHp(maxHp), currHp(maxHp), atk(atk), def(def) {
  for(int i = 0; i < 4; i++) {
    this->skills[i] = skills[i];
  }
}

void Pokemon::useSkill(Pokemon& opponent, unsigned short skillIndex) {
  // Check the error conditions
  if(skillIndex >= 4) throw invalid_argument("invalid skill index");
  if(skills[skillIndex] == NULL) throw invalid_argument("invalid skill index");

  // Get the skill and active it
  Skill* skill = skills[skillIndex];
  cout << name << " used " << skill->getName() << endl;
  skill->apply(*this, opponent);
}

int Pokemon::getAtk() const {
  return atk;
}

int Pokemon::getDef() const {
  return def;
}

int Pokemon::getHp() const {
  return currHp;
}

string Pokemon::getName() const {
  return name;
}

void Pokemon::addHp(int toAdd) {
  currHp += toAdd;
  // Avoid going under 0 if toAdd is negative
  currHp = max(0, currHp);
  // Avoid going over maxHp if toAdd is positive
  currHp = min(currHp, maxHp);

  if(toAdd > 0) cout << name << " gained " << toAdd << " HP" << endl;
  else if(toAdd < 0) cout << name << " lost " << -toAdd << " HP" << endl;
}

void Pokemon::addAtk(int toAdd) {
  atk += toAdd;
  // Avoid going under 0 if toAdd is negative
  atk = max(0, atk);

  if(toAdd > 0) cout << name << " gained " << toAdd << " ATK" << endl;
  else if(toAdd < 0) cout << name << " lost " << -toAdd << " ATK" << endl;
}
