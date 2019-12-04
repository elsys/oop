#include "./car_boat.hh"

CarBoat::CarBoat(float speed, float acceleration, float weight, float waterDisplacement) : Vehicle(speed, acceleration, weight), WaterVehicle(waterDisplacement) {}

void CarBoat::accelerate() {
  const int is_in_water = 0;

  if(is_in_water) {
    speed += acceleration * waterDisplacement/weight;
  } else {
    speed += acceleration - weight * G;
  }
}
