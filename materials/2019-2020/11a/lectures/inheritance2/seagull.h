#include "bird.h"
#include "canFly.h"

class Seagull : public Bird, CanFly {
  public:
	Seagull(int age);
	void eat_trash() const;
};
