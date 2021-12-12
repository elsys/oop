#include <iostream>

#include "Recipe.hh"
#include "Bar.hh"

using namespace std;

int main() {
  Bar b;

  b.load("example_recipes.txt");

  // No title
  // Recipe r = Recipe(
  //   "",
  //   "Recipe creation demo",
  //   {},
  //   {"some step", "some other step"}
  // );

  // No ingredients
  // Recipe r = Recipe(
  //   "Demo recipe",
  //   "Recipe creation demo",
  //   {},
  //   {"some step", "some other step"}
  // );

  // Title already exists
  // Recipe r = Recipe(
  //   "Another Recipe",
  //   "Recipe creation demo",
  //   {
  //     Ingredient("ing1", "25ml"),
  //     Ingredient("ing2", "100gr")
  //   },
  //   {"some step", "some other step"}
  // );

  // Matching title and ingredients, replace existing
  // Recipe r = Recipe(
  //   "Another Recipe",
  //   "Recipe creation demo",
  //   {
  //     Ingredient("tequila", "25ml"),
  //     Ingredient("whiskey", "25ml"),
  //     Ingredient("vodka", "50ml")
  //   },
  //   {"some step", "some other step"}
  // );

  // Unique and valid
  Recipe r = Recipe(
    "Demo recipe",
    "Recipe creation demo",
    {
      Ingredient("ing1", "25ml"),
      Ingredient("ing2", "100gr")
    },
    {"some step", "some other step"}
  );
  b.add(r);

  // 1 missing, not fine
  // const list<Recipe> found = b.search({"white rum", "pineapple juice"});
  // 1 missing, fine
  const list<Recipe> found = b.extended_search({"white rum", "pineapple juice"});
  // No missing, fine
  // const list<Recipe> found = b.search({"white rum", "vodka", "pineapple juice"});
  cout << found.size() << endl;
  for(auto it = found.begin(); it != found.end(); it++)
    cout << (*it) << endl;

  b.save("out.txt");

  return 0;
}
