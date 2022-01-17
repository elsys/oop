#include <iostream>
#include <cstdlib>

#include "pokemon.hh"
#include "skill.hh"
#include "skill_acid_armor.hh"
#include "skill_bite.hh"
#include "skill_growth.hh"
#include "skill_growl.hh"
#include "skill_heal.hh"
#include "skill_leech_seed.hh"
#include "skill_leer.hh"
#include "skill_pound.hh"

using namespace std;

int main() {
  // Initialize the random generator
  srand(time(NULL));

  // Create 2 pokemon with 4 skill each
  Skill* poke1_skills[4];
  poke1_skills[0] = new SkillAcidArmor();
  poke1_skills[1] = new SkillGrowl();
  poke1_skills[2] = new SkillHeal();
  poke1_skills[3] = new SkillLeer();
  Skill* poke2_skills[4];
  poke2_skills[0] = new SkillBite();
  poke2_skills[1] = new SkillGrowth();
  poke2_skills[2] = new SkillLeechSeed();
  poke2_skills[3] = new SkillPound();
  Pokemon poke1 = Pokemon("Bulbasaur", 200, 15, 10, poke1_skills);
  Pokemon poke2 = Pokemon("Pikachu", 150, 25, 8, poke2_skills);

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
