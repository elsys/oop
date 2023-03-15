package org.elsys.oop.cakefactory;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class CakeFactory {
    private List<Recipe> recipes = new LinkedList<Recipe>();
    private HashMap<String, Integer> ingredients = new HashMap<String, Integer>();
    private List<Order> orders = new LinkedList<Order>();

    public void addRecipe(Recipe recipe) {
        for (Recipe r : recipes)
            if (r.getName().equals(recipe.getName()))
                throw new IllegalArgumentException("Cannot add duplicate recipes");

        recipes.add(recipe);
    }

    public int getRecipeCount() {
        return recipes.size();
    }
}
