#pragma once

#include <fstream>
#include <string>
#include <vector>

using namespace std;

class Ingredient {
public:
  string name;
  string quantity;

  static Ingredient read(istream& in);

  Ingredient(string name, string quantity);
  friend bool operator==(const Ingredient& left, const Ingredient& right);
  friend ostream& operator<<(ostream& out, const Ingredient& recipe);
};

class Recipe {
  string title;
  string description;
  vector<Ingredient> ingredients;
  vector<string> steps;
public:
  static Recipe read(istream& in);

  Recipe(
    string title,
    string description,
    vector<Ingredient> ingredients,
    vector<string> steps
  );

  string getTitle() const;
  bool has_all_ingredients(vector<string> ingredients) const;
  bool has_some_ingredients(vector<string> ingredients, unsigned int max_missing) const;

  bool operator==(const Recipe& other) const;
  bool operator!=(const Recipe& other) const;
  friend ostream& operator<<(ostream& out, const Recipe& recipe);
};
