#include <iostream>
#include "salomon.h"

Salomon::Salomon(int age) : Fish(age), CanSwim() {}
Salomon::taste_good() const { std::cout << "Taste good" << std::endl; }
