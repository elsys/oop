#ifndef MILITARY_H
#define MILITARY_H

#include "plane.h"

class MilitaryPlane : public Plane{
	protected:
		int force;

	public:
		MilitaryPlane(){};

		MilitaryPlane(int size, std::string flight_number, 
						  std::string flight_model, bool is_civilian, 
						  bool is_military, float speed, float amount_fuel, 
						  float expense, float position_x, int force);

		MilitaryPlane(const MilitaryPlane& military_plane);
};

#endif
