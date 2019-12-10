#ifndef AIRPLANE_HH
#define AIRPLANE_HH

#include <string>
#include <iostream>
#include <list>
#include "airport.hh"

class Airport;

class Airplane {
  unsigned int size;
  unsigned int flight_number;
  std::string model;
  bool military;
  double speed;
  double fuel;
  double consumption_per_kilometer;
  double x;

public:
  class NoReachableAirportError {};

  Airplane(
      unsigned int size,
      unsigned int flight_number,
      std::string model,
      bool military,
      double speed,
      double fuel,
      double consumption_per_kilometer,
      double x);

  unsigned int get_size() const;

  unsigned int get_flight_number() const;

  std::string const& get_model() const;

  bool is_military() const;

  double get_speed() const;

  double get_fuel() const;

  double get_consumption_per_kilometer() const;

  double get_x() const;

  double distance_to_airport(Airport const& airport) const;

  bool can_reach(Airport const& airport) const;

  void land_in_nearest_airport(std::list<Airport>& airports);
};

std::ostream& operator<<(std::ostream& os, Airplane const& airplane);

#endif
