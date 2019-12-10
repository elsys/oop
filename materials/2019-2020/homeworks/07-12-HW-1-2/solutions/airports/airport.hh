#ifndef AIRPORT_HH
#define AIRPORT_HH

#include "airplane.hh"
#include <vector>

class Airplane;

class Airport {
  unsigned int max_airplane_count;
  double max_airplane_size;
  bool accepts_military;
  bool accepts_civil;
  std::vector<Airplane> airplanes;
  double x;

public:
  class CannotFitAirplaneError {};

  Airport(
      unsigned int max_airplane_count,
      double max_airplane_size,
      bool accepts_military,
      bool accepts_civil,
      double x);

  double get_x() const;

  bool can_fit_airplane(Airplane const& airplane);

  void land_airplane(Airplane const& airplane);
};

#endif
