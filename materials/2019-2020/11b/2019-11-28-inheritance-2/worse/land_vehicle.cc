#include "./land_vehicle.hh"

void LandVehicle::accelerate() {
  speed += acceleration - weight * 9.8;
}

LandVehicle::LandVehicle(float speed, float acceleration, float weight) : Vehicle(speed, acceleration, weight) {}
