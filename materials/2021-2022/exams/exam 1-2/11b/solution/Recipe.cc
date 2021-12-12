#include <iostream>
#include <fstream>
#include <string>
#include <stdexcept>
#include <sstream>

#include "Recipe.hh"

using namespace std;

//
// Ingredient
//
Ingredient Ingredient::read(istream& in) {
  string quantity;
  string name;

  in >> quantity;
  in.ignore(1);
  string line;
  getline(in, line);
  name = line;

  return Ingredient(name, quantity);
}

Ingredient::Ingredient(string name, string quantity) : name(name), quantity(quantity) {}

bool operator==(const Ingredient& left, const Ingredient& right) {
  return left.name == right.name && left.quantity == right.quantity;
}

ostream& operator<<(ostream& out, const Ingredient& recipe) {
  out << recipe.quantity << " " << recipe.name << endl;

  return out;
}

//
// Recipe
//
Recipe Recipe::read(istream& in) {
  string title;
  string description;
  vector<Ingredient> ingredients;
  vector<string> steps;

  string line;

  getline(in, line);
  title = line;
  getline(in, line);
  description = line;

  getline(in, line);
  while(1) {
    if(line.rfind("Step 1:") == 0) break;

    istringstream ss = istringstream(line);
    ingredients.push_back(Ingredient::read(ss));

    getline(in, line);
  }

  while(1) {
    if(line.empty()) break;

    steps.push_back(line.substr(line.rfind(":") + 2, line.size()));

    getline(in, line);
  }

  return Recipe(title, description, ingredients, steps);
}

Recipe::Recipe(
  string title,
  string description,
  vector<Ingredient> ingredients,
  vector<string> steps
) : title(title), description(description), ingredients(ingredients), steps(steps) {
  if(title.size() <= 0) throw invalid_argument("Title cannot be empty");
  if(ingredients.size() <= 0) throw invalid_argument("Ingredients cannot be empty");
  if(steps.size() <= 0) throw invalid_argument("Steps cannot be empty");
};

string Recipe::getTitle() const  { return title; }

bool Recipe::has_all_ingredients(vector<string> ingredients) const {
  return has_some_ingredients(ingredients, 0);
}

bool Recipe::has_some_ingredients(vector<string> ingredients, unsigned int max_missing) const {
  int found_count = 0;

  for(auto it = this->ingredients.begin(); it != this->ingredients.end(); it++) {
    Ingredient existing = *it;

    bool found = false;
    for(auto it2 = ingredients.begin(); it2 != ingredients.end(); it2++) {
      string to_find = *it2;
      if(existing.name == to_find) {
        found = true;
        break;
      }
    }

    if(found) {
      found_count++;
    }
  }

  if(found_count == 0) return false;

  if(this->ingredients.size() - found_count >= max_missing) {
    return false;
  }

  return true;
}

bool Recipe::operator==(const Recipe& other) const {
  if(title != other.title) return 0;
  if(ingredients != other.ingredients) return 0;

  return 1;
}

bool Recipe::operator!=(const Recipe& other) const {
  return !((*this) == other);
}

ostream& operator<<(ostream& out, const Recipe& recipe) {
  out << recipe.title << endl << recipe.description << endl;

  for(auto it = recipe.ingredients.begin(); it != recipe.ingredients.end(); it++)
    out << (*it);

  int i = 1;
  for(auto it = recipe.steps.begin(); it != recipe.steps.end(); it++, i++)
    out << "Step " << i << ": " << (*it) << endl;

  return out;
}
