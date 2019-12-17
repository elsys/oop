#ifndef LOAD_H
#define LOAD_H

#include "plane.h"

class LoadPlane : public Plane{
	protected:
		int curr_load;
		int max_load;

	public:
		LoadPlane(){};

		LoadPlane(int size, std::string flight_number, 
						std::string flight_model, bool is_civilian, 
						bool is_military, float speed, float amount_fuel, 
						float expense, float position_x, int curr_load, int max_load);

		LoadPlane(const LoadPlane& load_plane);
};

#endif
