/*
| LI | LI | E  | E  |
| LR | R  | DR | E  |
| LR | R  | DR | E  |
| P  | R  | M  | DI |
| MR | R  | R  | DI |
| MR | MR | DI | E  |
*/

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

  // Some houses
  entries.push_back({0, 1, new LightResidential()});
  entries.push_back({0, 2, new LightResidential()});

  entries.push_back({0, 4, new MediumResidential()});
  entries.push_back({0, 5, new MediumResidential()});
  entries.push_back({1, 5, new MediumResidential()});

  entries.push_back({2, 1, new DenseResidential()});
  entries.push_back({2, 2, new DenseResidential()});

  // Some leisure buildings
  entries.push_back({0, 3, new Park()});
  entries.push_back({2, 3, new Mall()});

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

  for(auto it = entries.begin(); it != entries.end(); it++) {
    input_entry_t entry = *it;

    try {
      demo_city.build(entry.x, entry.y, entry.cell);
    } catch(...) {
      cout << "some exception caught..." << endl;
    }
  }

  cout << city.getMaintenanceCost() << endl;  // should be 1*R + 2*LR + 4*MR + 6*DR + 8*M + 4*P + 4*LI + 6*DI = 5 + 4 + 12 + 6 + 8 + 4 + 8 + 18 = 65
  cout << city.getRoadLength() << endl;       // should be 1*R = 5
  cout << city.getResidentCapacity() << endl; // should be 5*LR + 20*MR + 50*DR = 10 + 60 + 50 = 120
  cout << city.getRequiredPower() << endl;    // should be 1*R + 2*LR + 4*MR + 8*DR + 4*M + 2*P + 4*LI + 8*DI = 5 + 4 + 12 + 8 + 4 + 2 + 8 + 24 = 67
  cout << city.getHappiness() << endl;        // should be 1 from the mall(next to 1 DR) + 3 from the park(next to 1 LR and 1 MR) - 2 from LI(next to 2 LR) - 6 from DI (next to 2 DR, and 1 M) = -7

  return 0;
}
