#include <vector>

#include "cell.hh"
#include "road.hh"

using namespace std;

Road::Road() :
  Cell({"Road"}, 1, 1),
  length(1)
{ }

int Road::getRoadLength() const {
  return length;
}

bool Road::canPlaceAt(const vector<vector<Cell*>>& matrix, unsigned int x, unsigned int y) const {
  return true;
}
