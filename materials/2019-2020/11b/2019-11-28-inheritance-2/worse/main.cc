#include <iostream>
using namespace std;

#include "./character.hh"
#include "./position.hh"

#include "./car.hh"
#include "./boat.hh"
#include "./car_boat.hh"

int main() {
  Car c = Car(0, 100, 5);
  c.accelerate();

  Boat b = Boat(0, 100, 5, 15);
  b.accelerate();

  CarBoat cb = CarBoat(0, 100, 5, 15);
  // request for member ‘accelerate’ is ambiguous
  // cb.accelerate();
  cb.LandVehicle::accelerate();
  cb.WaterVehicle::accelerate();

  cout << c.speed << " " << b.speed << " " << cb.LandVehicle::speed << " " << cb.WaterVehicle::speed << endl;
  return 0;
}
