#include <map>
#include <vector>
#include <string>
#include <iostream>

using namespace std;

int main() {
  map<int, float> hero_exerience;
  //hero_exerience.set("regularEXP", 100);
  hero_exerience[-15] = 50;
  hero_exerience[23] = 100;

  //cout << hero_exerience["regularEXP"] << endl;
  for(auto it = hero_exerience.begin(); it != hero_exerience.end(); it++) {
    cout << it->first << " -> " << it->second << endl;
  }

  return 0;
}
