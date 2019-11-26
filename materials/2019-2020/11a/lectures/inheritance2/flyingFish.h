#include "fish.h"
#include "canFly.h"
#include "canSwim.h"

class FlyingFish : public Fish, CanFLy, CanSwim {
  public:
	FlyingFish(int age);
	void run_away() const;
};
