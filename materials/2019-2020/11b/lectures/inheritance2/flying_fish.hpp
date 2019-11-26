#ifndef FLYING_FISH_HPP
#define FLYING_FISH_HPP

#include "fish.hpp"
#include "can_fly.hpp"
#include "can_swim.hpp"

class FlyingFish : public Fish, public CanFly, public CanSwim
{
public:
	void runAway();
};

#endif
