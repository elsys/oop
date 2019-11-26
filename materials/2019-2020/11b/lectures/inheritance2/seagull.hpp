#ifndef SEAGULL_HPP
#define SEAGULL_HPP

#include "bird.hpp"
#include "can_fly.hpp"
#include "can_walk.hpp"
#include "can_swim.hpp"

class Seagull : public Bird, public CanFly, public CanWalk, public CanSwim
{
public:
	void eatTrash();
};

#endif
