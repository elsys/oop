#ifndef PASSENGERPLANE_H
#define PASSENGERPLANE_H

#include "Plane.h"

class PassengerPlane : public Plane {
	public:
		int passenger_amount;
		int seats_amount;
		int exits_amount;
		
		PassengerPlane(int size, std::string model, bool is_allowed, int velocity, int fuel, int fuel_per_kilometer, float x);
		
		PassengerPlane(int size, std::string model, bool is_allowed, int velocity, int fuel, int fuel_per_kilometer, float x, int passenger_amount, int seats_amount, int exits_amount);
		PassengerPlane(PassengerPlane& p);
		
	std::ostream& operator<<(std::ostream& os);		
};


#endif
