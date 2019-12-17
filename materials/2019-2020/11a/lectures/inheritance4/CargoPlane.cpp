#include <iostream>
#include "CargoPlane.h"
#include "Plane.h"


CargoPlane::CargoPlane(int size, std::string model, bool is_allowed, int velocity, int fuel, int fuel_per_kilometer, float x) : Plane(size, model, is_allowed, velocity, fuel, fuel_per_kilometer, x) {}

CargoPlane::CargoPlane(int size, std::string model, bool is_allowed, int velocity, int fuel, int fuel_per_kilometer, float x, int current_weight, int max_weight) : Plane(size, model, is_allowed, velocity, fuel, fuel_per_kilometer, x), current_weight(current_weight), max_weight(max_weight) {}

CargoPlane::CargoPlane(CargoPlane& p) : Plane(p), current_weight(current_weight), max_weight(max_weight) {}
		
		
std::ostream& operator<<(std::ostream& os, CargoPlane& p) {os << p.current_weight << p.max_weight << std::endl; return os;}
