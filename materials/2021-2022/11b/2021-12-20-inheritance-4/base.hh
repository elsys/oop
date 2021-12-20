#pragma once

class Base {
// Allow chlid classes to access the properties
protected:
  unsigned int hp, def, atk;
public:
  Base(
    unsigned int hp,
    unsigned int def,
    unsigned int atk
  );
  // Virtual method - when overridden in a child class we get the child's
  // implementation regardless of what class we use it as
  virtual void attack(Base& other);

  // Helper to let us control how much damage is received when being hit
  virtual void takeDamage(unsigned int dmg);

  // Normal method - when overridden in a child class we get a different
  // implementation depending on what class we use it as
  int isAlive();

  unsigned int getDef();
};
