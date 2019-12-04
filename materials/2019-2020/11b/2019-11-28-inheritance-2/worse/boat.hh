#ifndef BOAR_HH
#define BOAR_HH

#include "./water_vehicle.hh"

class Boat : public WaterVehicle {
public:
  Boat(float speed, float acceleration, float weight, float waterDisplacement);
};

#endif
