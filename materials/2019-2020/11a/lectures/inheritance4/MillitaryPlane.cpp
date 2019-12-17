#include <iostream>
#include "MillitaryPlane.h"
#include "Plane.h"

MillitaryPlane::MillitaryPlane(int size, std::string model, bool is_allowed, int velocity, int fuel, int fuel_per_kilometer, float x) : Plane(size, model, is_allowed, velocity, fuel, fuel_per_kilometer, x) {}

MillitaryPlane::MillitaryPlane(int size, std::string model, bool is_allowed, int velocity, int fuel, int fuel_per_kilometer, float x, int weapon_power) : Plane(size, model, is_allowed, velocity, fuel, fuel_per_kilometer, x), weapon_power(weapon_power) {}

MillitaryPlane::MillitaryPlane(MillitaryPlane& p) : Plane(p), weapon_power(weapon_power) {}

std::ostream& operator<<(std::ostream& os, MillitaryPlane& p) {os << p.weapon_power; return os;}
