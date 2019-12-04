#ifndef CAR_BOAT_HH
#define CAR_BOAT_HH

#include "./land_vehicle.hh"
#include "./water_vehicle.hh"

class CarBoat : public LandVehicle, public WaterVehicle {
public:
  CarBoat(float speed, float acceleration, float weight, float waterDisplacement);
};

#endif
