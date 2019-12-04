#include <iostream>
using namespace std;

#include "./character.hh"
#include "./position.hh"

#include "./pistol.hh"
#include "./sword.hh"
#include "./pistol_sword.hh"

int main() {
  Pistol p = Pistol(10, 10, 100);
  p.pos = Position();
  Sword s = Sword(10, 15);
  s.pos = Position();
  PistolSword ps = PistolSword(10, 10,  100, 15);
  // error: request for member ‘pos’ is ambiguous
  // ps.pos = Position();
  ps.Shooty::pos = Position();

  Character t1;
  t1.pos = Position(5, 0, 0);
  t1.health = 100;
  Character t2;
  t2.pos = Position(12, 0, 0);
  t2.health = 100;

  p.attack(t1);
  p.attack(t2);
  cout << "t1.health after pistol " << t1.health << endl
       << "t2.health after pistol " << t2.health << endl;

  s.attack(t1);
  s.attack(t2);
  cout << "t1.health after sword " << t1.health << endl
       << "t2.health after sword " << t2.health << endl;

  // error: request for member ‘attack’ is ambiguous
  // ps.attack(t1);

  ps.Shooty::attack(t1);
  ps.Shooty::attack(t2);
  cout << "t1.health after pistolsword " << t1.health << endl
       << "t2.health after pistolsword " << t2.health << endl;

  return 0;
}
