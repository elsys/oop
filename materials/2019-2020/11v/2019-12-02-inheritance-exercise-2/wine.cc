#include "wine.hh"

Wine::Wine(
    std::string name,
    double volume,
    double price,
    double percentage,
    Kind kind)
  : Alcoholic(name, volume, price, percentage),
    kind(kind) {}

Wine::Kind Wine::get_kind() const {
  return kind;
}
