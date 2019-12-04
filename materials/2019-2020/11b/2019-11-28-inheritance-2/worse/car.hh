#ifndef CAR_HH
#define CAR_HH

#include "./land_vehicle.hh"

class Car : public LandVehicle {
public:
  Car(float speed, float acceleration, float weight);
};

#endif
