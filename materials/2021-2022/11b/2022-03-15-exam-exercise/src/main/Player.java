package main;

import buildable.AbstractBuildable;
import building.AbstractBuilding;
import building.IUpdatable;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Player {
    private String name;
    private List<AbstractBuildable> buildables = new LinkedList<>();
    private List<AbstractBuilding> buildings = new LinkedList<>();
    private Map<String, Integer> resources = new HashMap<>();

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<AbstractBuilding> getBuildings() {
        return buildings;
    }

    public Map<String, Integer> getResources() {
        return resources;
    }

    public void addResource(String key, int value) {
        Integer curr = resources.get(key);
        if (curr == null) curr = 0;

        resources.put(key, curr + value);
        System.out.println("Player " + name + ": Resource " + key + "(" + value + ") added for " + resources.get(key));
    }

    public void build(String id) throws Exception {
        for (AbstractBuildable b : buildables) {
            if (b.getId() == id) {
                if (!b.canBuild(this))
                    throw new Exception("Building " + b.getName() + "(" + b.getId() + ") cannot be built");

                AbstractBuilding result = b.build(this);
                buildings.add(result);

                Map<String, Integer> required = b.getRequiredResources();
                for (String k : required.keySet()) {
                    addResource(k, -required.get(k));
                }

                System.out.println("Player " + name + ": Built " + result.getName() + "(" + result.getId() + ")");
                return;
            }
        }

        throw new Exception("Building ID not found");
    }

    public void update() {
        for (IUpdatable b : buildings) {
            b.update(this);
        }
    }

    public void addBuildable(AbstractBuildable newBuildable) throws Exception {
        for (AbstractBuildable b : buildables) {
            if (b.getId() == newBuildable.getId()) throw new Exception("Buildable already exists");
        }

        buildables.add(newBuildable);
        System.out.println("Player " + name + ": Buildable " + newBuildable.getName() + "(" + newBuildable.getId() + ") added");
    }
}
