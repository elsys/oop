#ifndef VEHICLE_HH
#define VEHICLE_HH

#include "./entity.hh"

class Vehicle : public Entity {
public:
  float speed;
  float acceleration;
  float weight;
  int seatCount;

  Vehicle(float speed, float acceleration, float weight);

  void accelerate();
};

#endif
