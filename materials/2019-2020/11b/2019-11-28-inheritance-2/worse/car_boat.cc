#include "./car_boat.hh"

CarBoat::CarBoat(float speed, float acceleration, float weight, float waterDisplacement) : LandVehicle(speed, acceleration, weight), WaterVehicle(speed, acceleration, weight, waterDisplacement) {}
