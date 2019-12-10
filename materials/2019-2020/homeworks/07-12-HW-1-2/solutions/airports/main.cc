#include "airliner.hh"
#include "airfreighter.hh"
#include "military_aircraft.hh"
#include "airport.hh"
#include <list>

int main() {
  Airliner airliner(6, 42, "Jet-X", 500, 800, 8, 0, 20, 25, 4);
  Airfreighter airfreighter(5, 42, "Douglas DC-3", 500, 1200, 12, 0, 1000, 450);
  MilitaryAircraft military_aircraft(
      8, 42, "Boeing B-29 Superfortress", 500, 1000, 20, 0, 330);

  Airport luton(20, 7, false, true, 100);
  Airport heathrow(50, 10, true, true, 87);
  std::list<Airport> airports = { luton, heathrow };

  airliner.land_in_nearest_airport(airports);
  std::cout << airliner << '\n';

  airfreighter.land_in_nearest_airport(airports);
  std::cout << airfreighter << '\n';

  military_aircraft.land_in_nearest_airport(airports);
  std::cout << military_aircraft << '\n';

  return 0;
}
