#ifndef BOAR_HH
#define BOAR_HH

#include "./vehicle.hh"
#include "./water_vehicle.hh"

class Boat : public Vehicle, public WaterVehicle {
public:
  Boat(float speed, float acceleration, float weight, float waterDisplacement);

  void accelerate();
};

#endif
