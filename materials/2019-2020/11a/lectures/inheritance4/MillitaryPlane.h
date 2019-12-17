#ifndef MILLITARYPLANE_H
#define MILLITARYPLANE_H

#include "Plane.h"
#include <iostream>

class MillitaryPlane : public Plane {
		public:
			int weapon_power;
			
			MillitaryPlane(int size, std::string model, bool is_allowed, int velocity, int fuel, int fuel_per_kilometer, float x);
			MillitaryPlane(int size, std::string model, bool is_allowed, int velocity, int fuel, int fuel_per_kilometer, float x, int weapon_power);
			MillitaryPlane(MillitaryPlane& p);
};

std::ostream& operator<<(std::ostream& os, MillitaryPlane& p);

#endif
