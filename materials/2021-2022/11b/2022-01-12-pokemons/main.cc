#include <iostream>
#include <cstdlib>

#include "pokemon.hh"
#include "skill.hh"
#include "skill_bite.hh"
#include "skill_pound.hh"
#include "skill_heal.hh"
#include "skill_charm.hh"
#include "skill_meditate.hh"

using namespace std;

int main() {
  // Initialize the random generator
  srand(time(NULL));

  // Create 2 pokemon with 4 skill each
  Skill* poke1_skills[4];
  poke1_skills[0] = new SkillBite();
  poke1_skills[1] = new SkillPound();
  poke1_skills[2] = new SkillHeal();
  poke1_skills[3] = new SkillCharm();
  Skill* poke2_skills[4];
  poke2_skills[0] = new SkillBite();
  poke2_skills[1] = new SkillPound();
  poke2_skills[2] = new SkillHeal();
  poke2_skills[3] = new SkillMeditate();
  Pokemon poke1 = Pokemon("Demo1", 200, 15, 10, poke1_skills);
  Pokemon poke2 = Pokemon("Demo2", 150, 25, 8, poke2_skills);

  cout << "Start battle" << endl;
  try {
    int roundCounter = 0;
    // Fight until 1 pokemon loses all HP
    while(poke1.getHp() > 0 && poke2.getHp() > 0) {
      roundCounter++;
      cout << "Round " << roundCounter << endl;

      // Choose random skills
      poke1.useSkill(poke2, rand() % 4);
      if(poke2.getHp() <= 0) break;

      poke2.useSkill(poke1, rand() % 4);
    }
  } catch(invalid_argument e) {
    cout << "!!! Caught exception: " << e.what() << endl;
  }
  cout << "Battle is over" << endl;

  // Check who is the winner
  Pokemon* winner = &poke1;
  if(poke2.getHp() > 0) winner = &poke2;

  cout << winner->getName() << " wins" << endl;

  return 0;
}
