#ifndef LION_HPP
#define LION_HPP

#include "mammal.hpp"
#include "can_walk.hpp"

class Lion : public Mammal, public CanWalk
{
public:
	void roar();
};

#endif
