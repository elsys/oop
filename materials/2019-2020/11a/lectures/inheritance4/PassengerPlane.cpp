#include <iostream>
#include "PassengerPlane.h"
#include "Plane.h"

using namespace std;

PassengerPlane::PassengerPlane(int size, std::string model, bool is_allowed, int velocity, int fuel, int fuel_per_kilometer, float x) : Plane(size, model, is_allowed, velocity, fuel, fuel_per_kilometer, x) {}

PassengerPlane::PassengerPlane(int size, std::string model, bool is_allowed, int velocity, int fuel, int fuel_per_kilometer, float x, int passenger_amount, int seats_amount, int exits_amount) : Plane(size, model, is_allowed, velocity, fuel, fuel_per_kilometer, x), passenger_amount(passenger_amount), seats_amount(seats_amount), exits_amount(exits_amount) {}

PassengerPlane::PassengerPlane(PassengerPlane& p) : Plane(p), passenger_amount(p.passenger_amount), seats_amount(p.seats_amount), exits_amount(p.exits_amount) {}

ostream& PassengerPlane::operator<<(ostream& os) {os << this->passenger_amount << this->seats_amount << this->exits_amount << endl; return os;}
