#include "mammal.h"
#include "canWalk.h"

class Lion : public Mammal, CanWalk {
  public:
	Lion(int age, int children);
	void roar() const;
};
