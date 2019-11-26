#include <iostream>
#include "lion.hpp"
#include "whale.hpp"
#include "salmon.hpp"
#include "flying_fish.hpp"
#include "seagull.hpp"
#include "ostrich.hpp"


int main()
{
	FlyingFish my_fish = FlyingFish();
	
	my_fish.runAway();
	my_fish.fly();
	return 0;
}
