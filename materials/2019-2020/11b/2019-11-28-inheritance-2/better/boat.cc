#include "./boat.hh"

Boat::Boat(float speed, float acceleration, float weight, float waterDisplacement) : Vehicle(speed, acceleration, weight), WaterVehicle(waterDisplacement) {}

void Boat::accelerate() {
  speed += acceleration * waterDisplacement/weight;
}
