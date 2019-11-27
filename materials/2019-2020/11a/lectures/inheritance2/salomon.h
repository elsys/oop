#include "fish.h"
#include "canSwim.h"

class Salomon : public Fish, CanSwim {
  public:
	Salomon(int age);
	void taste_good() const;
};
