#include "./car.hh"

Car::Car(float speed, float acceleration, float weight) : Vehicle(speed, acceleration, weight) {}

void Car::accelerate() {
  speed += acceleration - weight * G;
}
