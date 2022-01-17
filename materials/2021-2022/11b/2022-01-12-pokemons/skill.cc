#include "skill.hh"

Skill::Skill(string name) : name(name) {}

string Skill::getName() const {
  return name;
}
