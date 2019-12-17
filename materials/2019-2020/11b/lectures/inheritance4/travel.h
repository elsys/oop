#ifndef TRAVEL_H
#define TRAVEL_H

#include "plane.h"

class TravelPlane : public Plane{
	protected:
		int passengers;
		int seats;
		int exits;

	public:
		TravelPlane(){};

		TarvelPlane(int size, std::string flight_number, 
						std::string flight_model, bool is_civilian, 
						bool is_military, float speed, float amount_fuel, 
						float expense, float position_x, int passengers,
						int seats, int exits);

		TravelPlane(const TravelPlane& travel_plane);
};

#endif
