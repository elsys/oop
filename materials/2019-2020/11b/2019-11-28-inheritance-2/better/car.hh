#ifndef CAR_HH
#define CAR_HH

#include "./vehicle.hh"
#include "./land_vehicle.hh"

class Car : public Vehicle, public LandVehicle {
public:
  Car(float speed, float acceleration, float weight);

  void accelerate();
};

#endif
