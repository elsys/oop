#ifndef OSTRICH_HPP
#define OSTRICH_HPP

#include "bird.hpp"
#include "can_walk.hpp"

class Ostrich : public Bird, public CanWalk
{
public:
	void bigEggs();
};

#endif
