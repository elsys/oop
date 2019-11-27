#include <iostream>
#include "ostrech.h"

Ostrich::Ostrich(int age) : Bird(age), CanWalk() {}
void Ostrich::big_eggs const () { std::cout << "Big eggs" << std::endl; }
