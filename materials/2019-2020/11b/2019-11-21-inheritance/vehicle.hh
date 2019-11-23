#ifndef VEHICLE_HH
#define VEHICLE_HH

#include "./entity.hh"

class Vehicle : public Entity {
protected:
  float speed;
  int seatCount;
};

#endif
