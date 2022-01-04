#include <iostream>

#include "mafioso.hh"

using namespace std;

Mafioso::Mafioso(
  unsigned int hp,
  unsigned int def,
  unsigned int atk
) : Base(hp, def, atk) {
  cout << "Mafioso::Mafioso" << endl;
}

ToughGuy::ToughGuy(
  unsigned int hp,
  unsigned int def,
  unsigned int atk
) : Mafioso(hp, def, atk) {
  cout << "ToughGuy::ToughGuy" << endl;
}

void ToughGuy::takeDamage(unsigned int dmg) {
  cout << "ToughGuy::takeDamage" << endl;
  cout << "\tInitial dmg " << dmg << endl;
  // Half the received damage
  Base::takeDamage(dmg / 2);
}

Specialist::Specialist(
  unsigned int hp,
  unsigned int def,
  unsigned int atk,
  unsigned int grenadeAtk
) : Mafioso(hp, def, atk), grenadeAtk(grenadeAtk) {
  cout << "Specialist::Specialist" << endl;
}

void Specialist::attack(Base& other) {
  cout << "Specialist::attack" << endl;

  if(other.getDef() > atk * 0.6) {
    // other.def is too high => grenade attack
    cout << "\tUse grenade " << grenadeAtk << endl;
    other.takeDamage(grenadeAtk);
    takeDamage(grenadeAtk * 0.1);
  } else {
    // other.def is low enough => normal attack
    cout << "\tUse normal attack " << endl;
    Base::attack(other);
  }
}
