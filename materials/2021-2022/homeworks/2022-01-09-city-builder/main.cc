#include <list>
#include <string>
#include <iostream>
#include <iomanip>

#include "cell.hh"
#include "city.hh"

#include "road.hh"
#include "leisure.hh"
#include "industrial.hh"
#include "residential.hh"

using namespace std;

struct input_entry_t {
  int x;
  int y;
  Cell* cell;
};

int main() {
  list<input_entry_t> entries;

  // Some roads
  entries.push_back({1, 1, new Road()});
  entries.push_back({1, 2, new Road()});
  entries.push_back({1, 3, new Road()});
  entries.push_back({1, 4, new Road()});
  entries.push_back({2, 4, new Road()});

  // Some leisure buildings
  entries.push_back({0, 3, new Park()});
  entries.push_back({2, 3, new Mall()});

  // Some houses
  entries.push_back({0, 1, new LightResidential()});
  entries.push_back({0, 2, new LightResidential()});

  entries.push_back({0, 4, new MediumResidential()});
  entries.push_back({0, 5, new MediumResidential()});
  entries.push_back({1, 5, new MediumResidential()});

  entries.push_back({2, 2, new DenseResidential()});

  // Some industry
  entries.push_back({0, 0, new LightIndustrial()});
  entries.push_back({1, 0, new LightIndustrial()});

  entries.push_back({3, 3, new DenseIndustrial()});
  entries.push_back({3, 4, new DenseIndustrial()});
  entries.push_back({2, 5, new DenseIndustrial()});

  // Out of bounds
  entries.push_back({25, 3, new Road()});
  entries.push_back({-25, 3, new Road()});

  // No nearby road
  entries.push_back({3, 0, new LightResidential()});

  // No nearby leisure
  entries.push_back({2, 1, new DenseResidential()});

  City demo_city = City(4, 6);

  demo_city.printMatrix();
  cout << endl;

  for(auto it = entries.begin(); it != entries.end(); it++) {
    input_entry_t entry = *it;

    try {
      demo_city.build(entry.x, entry.y, entry.cell);
    } catch(exception& ex) {
      cout << ex.what() << endl;
    } catch(...) {
      cout << "some exception caught..." << endl;
    }

    cout << endl;
  }

  cout << endl;
  demo_city.printMatrix();

  cout << endl;
  cout << left << setw(12) << "Maintenance:" << setw(5) << right << demo_city.getMaintenanceCost()  << endl;
  cout << left << setw(12) << "Roads:"       << setw(5) << right << demo_city.getRoadLength()       << endl;
  cout << left << setw(12) << "Residents:"   << setw(5) << right << demo_city.getResidentCapacity() << endl;
  cout << left << setw(12) << "Power:"       << setw(5) << right << demo_city.getRequiredPower()    << endl;
  cout << left << setw(12) << "Happiness:"   << setw(5) << right << demo_city.getHappiness()        << endl;

  return 0;
}
