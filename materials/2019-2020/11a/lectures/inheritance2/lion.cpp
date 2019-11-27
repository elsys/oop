#include <iostream>
#include "lion.h"

Lion::Lion(int age, int children) : Mammal(age, children), CanWalk() {}
void Lion::roar() const { std::cout << "Roar" << std::endl; }
