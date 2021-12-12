#include <stdexcept>
#include <fstream>

#include "Bar.hh"

using namespace std;

Bar::Bar() {}

void Bar::add(Recipe recipe) {
  for(auto it = recipes.begin(); it != recipes.end(); it++) {
    const Recipe existing = *it;

    if(existing == recipe) {
      it = recipes.erase(it);
      recipes.insert(it, recipe);
      return;
    }

    if(existing.getTitle() == recipe.getTitle()) throw invalid_argument("Recipe already exists");
  }

  recipes.push_back(recipe);
}

void Bar::load(string file_path) {
  ifstream in = ifstream(file_path);

  if(!in)
    throw runtime_error("Cannot open file " + file_path);

  while(!in.eof())
    recipes.push_back(Recipe::read(in));

  in.close();
}

void Bar::save(string file_path) const {
  ofstream out = ofstream(file_path);

  if(!out)
    throw runtime_error("Cannot open file " + file_path);

  for(auto it = recipes.begin(); it != recipes.end(); it++)
    out << (*it) << endl;

  out.close();
}

const list<Recipe> Bar::search(vector<string> ingredients) const {
  if(ingredients.empty()) throw invalid_argument("Ingredient list cannot be empty");

  list<Recipe> found;

  for(auto it = recipes.begin(); it != recipes.end(); it++) {
    Recipe recipe = *it;

    if(recipe.has_all_ingredients(ingredients)) found.push_back(recipe);
  }

  return found;
}

const list<Recipe> Bar::extended_search(vector<string> ingredients) const {
  if(ingredients.empty()) throw invalid_argument("Ingredient list cannot be empty");

  list<Recipe> found;

  for(auto it = recipes.begin(); it != recipes.end(); it++) {
    Recipe recipe = *it;

    if(recipe.has_some_ingredients(ingredients, 2)) found.push_back(recipe);
  }

  return found;
}
