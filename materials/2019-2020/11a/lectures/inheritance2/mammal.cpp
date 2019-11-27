#include <iostream>
#include "mammal.h"

Mammal::Mammal(int age, int children) : Animal(age), children(children) {}
int Mammal::get_children() const { return children; }
void Mammal::set_children(int children) { this->children = children; }
void Mammal::give_birth(int children) {
	this->children += children;
	std::cout << "Give birth" << std::endl;
}
