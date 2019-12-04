#include "./water_vehicle.hh"

void WaterVehicle::accelerate() {
  speed += acceleration * waterDisplacement/weight;
}

WaterVehicle::WaterVehicle(float speed, float acceleration, float weight, float waterDisplacement) : Vehicle(speed, acceleration, weight), waterDisplacement(waterDisplacement) {}
