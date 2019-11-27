#include <iostream>
#include "seagull.h"

Seagull::Seagull(int age) : Bird(age), CanFly() {}
void Seagull::eat_trash const () { std::cout << "Eat trash" << endl; }
