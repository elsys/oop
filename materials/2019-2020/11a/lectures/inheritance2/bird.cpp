#include <iostream>
#include "bird.h"

Bird::Bird(int age) : Animal(age) {}
void Bird::lay_eggs() const { std::cout << "Lay eggs" << std::endl; }
