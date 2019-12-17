#ifndef PLANE_H
#define PLANE_H

#include <iostream>
#include <string>
#include <list>

class Airport; //forward definition of class Airport -> tells there exists a class of such a name

class Plane {
	public:
		int size;
		std::string model;
		bool is_allowed; //true -> passenger; false -> millitary
		int velocity;
		int fuel;
		int fuel_per_kilometer;
		float x;
		
		Plane();
		Plane(int size, std::string model, bool is_allowed, int velocity, int fuel, int fuel_per_kilometer, float x);
		Plane(const Plane& p);
		
		float distance_to_airport(Airport& airp);
		bool can_reach(Airport& airp);
		void land_in_nearest_airport(std::list<Airport> airports);
};

std::ostream& operator<<(std::ostream& os, Plane& p); //& -> reference

#endif
