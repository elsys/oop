#pragma once

#include <vector>

#include "cell.hh"

using namespace std;

class Road : public Cell {
  int length;
public:
  Road();
  int getRoadLength() const;
  bool canPlaceAt(const vector<vector<Cell*>>& matrix, unsigned int x, unsigned int y) const;
};
