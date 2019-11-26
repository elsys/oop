#include "animal.h"

Animal::Animal(int age) : age(age) {}
int Animal::get_age() const { return age; }
void Animal::set_age(int age) { this->age = age; }
