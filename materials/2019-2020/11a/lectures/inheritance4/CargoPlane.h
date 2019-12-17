#ifndef CARGOPLANE_H
#define CARGOPLANE_H

#include <iostream>
#include "Plane.h"
#include "Airport.h"

class CargoPlane : public Plane {
	public:
		
		int current_weight;
		int max_weight;
		
		CargoPlane(int size, std::string model, bool is_allowed, int velocity, int fuel, int fuel_per_kilometer, float x);
		
		CargoPlane(int size, std::string model, bool is_allowed, int velocity, int fuel, int fuel_per_kilometer, float x, int current_weight, int max_weight);
		CargoPlane(CargoPlane& p);
		
		float distance_to_airport(Airport& airport);
};

std::ostream& operator<<(std::ostream& os, CargoPlane& p);

#endif
