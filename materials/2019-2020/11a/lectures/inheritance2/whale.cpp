#include <iostream>
#include "whale.h"

Whale::Whale(int age, int children) : Mammal(age, children), CanSwim() {}
void Whale::oooo() const { std::cout << "Oooo" << std::endl; }
