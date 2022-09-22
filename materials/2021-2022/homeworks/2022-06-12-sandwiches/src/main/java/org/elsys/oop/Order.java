package org.elsys.oop;

import java.util.*;
import java.util.stream.Collectors;

public class Order implements Comparable<Order> {
    public final static int bakeTIme = 2500;
    private final static Map<String, List<String>> validIngredients = Map.of(
            "bread", Arrays.asList("white bread", "black bread"),
            "meat", Arrays.asList("ham", "beef"),
            "cheese", Arrays.asList("cheese", "cream cheese"),
            "added", Arrays.asList("tomato", "onion", "cucumber", "iceberg", "pickles", "olives"),
            "sauce", Arrays.asList("mayonnaise", "barbecue sauce", "ranch")
    );
    private final static Map<String, Integer> placementTimes = Map.of(
            "bread", 1500,
            "meat", 1200,
            "cheese", 1200,
            "added", 1200,
            "sauce", 1200
    );
    private static int idCounter = 0;
    private final int id;
    private final Map<String, List<String>> ingredients;
    private final List<String> specialRequirements;
    boolean isBaked = false;

    public Order(List<String> ingredients, List<String> specialRequirements) {
        // Preprocess the ingredients and group them by type
        Set<Map.Entry<String, List<String>>> validSet = validIngredients
                .entrySet();
        this.ingredients =
                ingredients
                        .stream()
                        .collect(Collectors.groupingBy((v) ->
                                validSet
                                        .stream()
                                        .filter((e) -> e.getValue().contains(v))
                                        .map(Map.Entry::getKey)
                                        .findFirst()
                                        .orElse("")
                        ));

        this.specialRequirements = specialRequirements;
        id = idCounter++;
    }

    public static int getPlacementTime(String ingredient) {
        String type = validIngredients
                .entrySet()
                .stream()
                .filter((e) -> e.getValue().contains(ingredient))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse("");

        if (!placementTimes.containsKey(type)) throw new IllegalArgumentException("Ingredient is invalid");

        return placementTimes.get(type);
    }

    public static Order GetClassicHamOrder(String bread) {
        return new Order(
                Arrays.asList(bread, "ham", "cheese", "tomato", "onion", "cucumber", "mayonnaise"),
                new ArrayList<String>()
        );
    }

    public static Order GetLongBurderOrder(String bread) {
        return new Order(
                Arrays.asList(bread, "beef", "cream cheese", "iceberg", "pickles", "barbecue sauce"),
                new ArrayList<String>()
        );
    }

    public static Order GetVeggieDelightOrder(String bread) {
        return new Order(
                Arrays.asList(bread, "cheese", "iceberg", "olives", "tomato", "ranch"),
                new ArrayList<String>()
        );
    }

    public int getId() {
        return id;
    }

    public List<String> getPendingIngredients() {
        List<String> result = new LinkedList<>();

        if (!needsBaking()) {
            result = ingredients.values().stream().collect(ArrayList::new, List::addAll, List::addAll);
        } else {
            if (!isBaked) {
                result.addAll(ingredients.get("bread"));
                result.addAll(ingredients.get("meat"));
                result.addAll(ingredients.get("cheese"));
            } else {
                result.addAll(ingredients.get("added"));
                result.addAll(ingredients.get("sauce"));
            }
        }

        return result;
    }

    public boolean needsBaking() {
        return specialRequirements.stream().noneMatch(v -> v.equals("no bake"));
    }

    public boolean isValid() {
        if (ingredients.containsKey("")) return false;
        if (ingredients.get("bread").size() != 1) return false;
        if (ingredients.get("meat").size() != 1) return false;
        if (ingredients.get("cheese").size() != 1) return false;
        if (ingredients.get("added").size() < 1 || ingredients.get("added").size() > 3) return false;
        return ingredients.get("sauce").size() >= 1 && ingredients.get("sauce").size() <= 3;
    }

    @Override
    public int compareTo(Order o) {
        if (isBaked && !o.isBaked) return 1;
        if (!isBaked && o.isBaked) return -1;
        return 0;
    }
}
