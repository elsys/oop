#pragma once

#include <string>
#include <list>
#include <vector>

#include "Recipe.hh"

using namespace std;

class Bar {
  list<Recipe> recipes;
public:
  Bar();

  void add(Recipe recipe);
  void load(string file_path);
  void save(string file_path) const;
  const list<Recipe> search(vector<string> ingredients) const;
  const list<Recipe> extended_search(vector<string> ingredients) const;
};
