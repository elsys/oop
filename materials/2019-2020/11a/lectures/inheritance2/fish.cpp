#include <iostream>
#include "fish.h"

Fish::Fish(int age) : Animal(age) {}
void Fish::give_cavier() const { std::cout << "Give cavier" << std::endl; }
