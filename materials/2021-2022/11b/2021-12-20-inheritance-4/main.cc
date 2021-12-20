#include <iostream>

#include "mafioso.hh"
#include "policeman.hh"

using namespace std;

// This will work even if we define the args as Base&
// since everything used is defined in the base class
void fight(Mafioso& m, Policeman& p) {
  cout << endl << "Start fight" << endl;
  while(m.isAlive() && p.isAlive()) {
    p.attack(m);
    if(m.isAlive())
      m.attack(p);
  }
  cout << "End fight" << endl;
}

int main() {
  Mafioso m1 = Mafioso(10, 3, 5);
  ToughGuy m2 = ToughGuy(10, 3, 5);
  Specialist m3 = Specialist(10, 3, 5, 4);

  Policeman p1 = Policeman(20, 6, 6);
  Enforcer p2 = Enforcer(20, 6, 6);
  Swat p3 = Swat(20, 6, 6);

  fight(m3, p3);

  return 0;
}
