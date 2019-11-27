#include "animal.h"

class Bird : public Animal {
  public:
	Bird(int age);
	void lay_eggs() const;
};
