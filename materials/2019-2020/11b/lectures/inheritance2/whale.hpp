#ifndef WHALE_HPP
#define WHALE_HPP

#include "mammal.hpp"
#include "can_swim.hpp"

class Whale : public Mammal, public CanSwim
{
public:
	void ooooo();
};

#endif
