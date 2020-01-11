#include "acoustic.hh"
#include "electric.hh"
#include "music_store.hh"
#include <iostream>

int main() {
  Acoustic guild(1, 2200, "Guild", 12, 22, 5, 10);
  Acoustic martin(2, 1300, "Martin", 6, 22, 3, 8);
  Electric gibson(3, 4800, "Gibson", 12, 22, 9, 2, 13);
  Electric fender(4, 3100, "Fender", 6, 21, 4, 3, 11);

  MusicStore music_store;
  music_store.add_acoustic(guild);
  music_store.add_acoustic(martin);
  music_store.add_electric(gibson);
  music_store.add_electric(fender);

  std::cout << music_store.get_all_in_price_range(1000, 3000).size() << '\n';
  std::cout << music_store.get_all_twelve_strings().size() << '\n';
  std::cout << music_store.get_most_powerful_acoustic().get_id() << '\n';
  std::cout << music_store.get_most_powerful_electric().get_id() << '\n';

  music_store.buy(guild);
  std::cout << music_store.get_all_in_price_range(1000, 3000).size() << '\n';
  std::cout << music_store.get_all_in_price_range(1000, 5000).size() << '\n';

  return 0;
}
