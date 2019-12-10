#include "airliner.hh"

Airliner::Airliner(
    unsigned int size,
    unsigned int flight_number,
    std::string model,
    double speed,
    double fuel,
    double consumption_per_kilometer,
    double x,
    unsigned int passengers,
    unsigned int seats,
    unsigned int exits)
  :
    Airplane(
        size, flight_number, model, false, speed,
        fuel, consumption_per_kilometer, x),
    passengers(passengers),
    seats(seats),
    exits(exits) {}

unsigned int Airliner::get_passengers() const {
  return passengers;
}

unsigned int Airliner::get_seats() const {
  return seats;
}

unsigned int Airliner::get_exits() const {
  return exits;
}

std::ostream& operator<<(std::ostream& os, Airliner const& airliner) {
  return os
    << (Airplane)airliner << '\n'
    << "Passengers: " << airliner.get_passengers() << '\n'
    << "Seats: " << airliner.get_seats() << '\n'
    << "Exits: " << airliner.get_exits();
}
