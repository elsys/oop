#include "bird.h"
#include "canWalk.h"

class Ostrich : public Bird, CanWalk {
  public:
	Ostrich(int age);
	void big_eggs() const;	
};
