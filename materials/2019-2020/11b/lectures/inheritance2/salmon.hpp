#ifndef SALMON_HPP
#define SALMON_HPP

#include "fish.hpp"
#include "can_swim.hpp"

class Salmon : public Fish, public CanSwim
{
public:
	bool tastesGood();
};

#endif
