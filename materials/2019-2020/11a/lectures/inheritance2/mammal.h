#include "animal.h"

class Mammal : public Animal {
	int children;
  public:
	Mammal(int age, int children);
	int get_children() const;
	void set_children(int children);
	void give_birth(int children);
};
