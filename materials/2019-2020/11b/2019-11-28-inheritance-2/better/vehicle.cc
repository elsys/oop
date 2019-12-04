#include "./vehicle.hh"

void Vehicle::accelerate() {
  speed += acceleration;
}

Vehicle::Vehicle(float speed, float acceleration, float weight) : speed(speed), acceleration(acceleration), weight(weight) {}
