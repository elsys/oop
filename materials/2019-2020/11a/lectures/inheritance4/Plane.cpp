#include "Plane.h"
#include "Airport.h"
#include <list>
#include <iostream>
#include <cmath>

class CantLandPlane {};

using namespace std;

Plane::Plane() {}

Plane::Plane(int size, std::string model, bool is_allowed, int velocity, int fuel, int fuel_per_kilometer, float x) : size(size), model(model), is_allowed(is_allowed), velocity(velocity), fuel(fuel), fuel_per_kilometer(fuel_per_kilometer), x(x) {}

Plane::Plane(const Plane& p) : size(p.size), model(p.model), is_allowed(p.is_allowed), velocity(p.velocity), fuel(p.fuel), fuel_per_kilometer(p.fuel_per_kilometer), x(p.x) {}

std::ostream& operator<<(std::ostream& os, Plane& p) {os << p.size << p.model << p.is_allowed << p.velocity << p.fuel << p.fuel_per_kilometer << p.x << endl; return os;} //& -> reference

float Plane::distance_to_airport(Airport& airp) {return abs(airp.x - x);}
bool Plane::can_reach(Airport& airp) {return fuel >= fuel_per_kilometer * velocity;}
void Plane::land_in_nearest_airport(std::list<Airport> airports) {
	std::list<Airport>::iterator myIt = airports.begin();
	for(myIt; myIt != airports.end(); myIt++) {
		if(myIt->can_fit_plane(*this)) {
			myIt->land_plane(*this);
			return;
		}
	}
	
	throw CantLandPlane();
}
