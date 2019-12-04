#ifndef WATER_VEHICLE_HH
#define WATER_VEHICLE_HH

#include "./vehicle.hh"

class WaterVehicle : public Vehicle {
public:
  float waterDisplacement;

  WaterVehicle(float speed, float acceleration, float weight, float waterDisplacement);

  void accelerate();
};

#endif
