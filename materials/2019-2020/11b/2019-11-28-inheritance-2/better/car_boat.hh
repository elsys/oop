#ifndef CAR_BOAT_HH
#define CAR_BOAT_HH

#include "./vehicle.hh"
#include "./land_vehicle.hh"
#include "./water_vehicle.hh"

class CarBoat : public Vehicle, public LandVehicle, public WaterVehicle {
public:
  CarBoat(float speed, float acceleration, float weight, float waterDisplacement);

  void accelerate();
};

#endif
