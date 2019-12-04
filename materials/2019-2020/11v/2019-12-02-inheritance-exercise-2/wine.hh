#ifndef WINE_HH
#define WINE_HH

#include "alcoholic.hh"
#include <string>

class Wine : public Alcoholic {
public:
  enum Kind {
    red,
    white,
    rose,
  };

private:
  Kind kind;

public:
  Wine(
      std::string name,
      double volume,
      double price,
      double percentage,
      Kind kind = red);

  Kind get_kind() const;
};

#endif
