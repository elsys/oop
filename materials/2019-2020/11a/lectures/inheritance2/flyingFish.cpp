#include <iostream>
#include "flyingFish.h"

FlyingFish::FlyingFish(int age) : Fish(age), CanFly(), CanSwim() {}
void FlyingFish::run_away const () { std::cout << "Run away" << std::endl; }
