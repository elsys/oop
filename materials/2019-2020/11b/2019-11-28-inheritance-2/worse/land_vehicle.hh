#ifndef LAND_VEHICLE_HH
#define LAND_VEHICLE_HH

#include "./vehicle.hh"

class LandVehicle : public Vehicle {
public:
  LandVehicle(float speed, float acceleration, float weight);

  void accelerate();
};

#endif
