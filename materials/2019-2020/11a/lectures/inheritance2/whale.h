#include "mammal.h"
#include "canSwim.h"

class Whale : public Mammal, CanSwim {
  public:
	Whale(int age, int children);
	void oooo() const;
};
