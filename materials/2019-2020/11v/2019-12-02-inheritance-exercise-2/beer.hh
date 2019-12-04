#ifndef BEER_HH
#define BEER_HH

#include "alcoholic.hh"
#include <string>

class Beer : public Alcoholic {
  bool dark;

public:
  Beer(
      std::string name,
      double volume,
      double price,
      double percentage,
      bool dark = false);

  bool is_dark() const;
};

#endif
