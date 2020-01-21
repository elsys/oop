#ifndef WALKER_HH
#define WALKER_HH

#include <string>

class Walker {
  std::string description;
  double average_speed;

public:
  Walker(std::string const& description, double average_speed);

  double get_average_speed() const;

  virtual Walker* clone() const;

  virtual double walk(double distance);
};

#endif
